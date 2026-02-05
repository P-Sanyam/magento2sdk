package com.magento2.integration.config;

import com.magento2.integration.client.MagentoApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MagentoClientConfig {
    @Bean
    public MagentoApiClient magentoApiClient(WebClient magentoWebClient) {
        return new MagentoApiClient(magentoWebClient);
    }
}
