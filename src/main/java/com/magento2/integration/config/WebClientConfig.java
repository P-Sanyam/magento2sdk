package com.magento2.integration.config;

import com.magento2.integration.auth.BearerTokenProvider;
import com.magento2.integration.auth.StaticBearerTokenProvider;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableConfigurationProperties(MagentoApiProperties.class)
public class WebClientConfig {
    @Bean
    public BearerTokenProvider bearerTokenProvider(MagentoApiProperties properties) {
        return new StaticBearerTokenProvider(properties.getBearerToken());
    }

    @Bean
    public WebClient magentoWebClient(MagentoApiProperties properties, BearerTokenProvider tokenProvider) {
        HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.getTimeoutSeconds() * 1000)
            .responseTimeout(Duration.ofSeconds(properties.getTimeoutSeconds()))
            .doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler(properties.getTimeoutSeconds()))
                .addHandlerLast(new WriteTimeoutHandler(properties.getTimeoutSeconds())));

        ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
            .build();

        return WebClient.builder()
            .baseUrl(properties.getBaseUrl())
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .exchangeStrategies(strategies)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + tokenProvider.getToken())
            .build();
    }
}
