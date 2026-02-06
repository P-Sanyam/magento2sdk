package com.magento2.integration.client;

import com.magento2.integration.exception.MagentoApiException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MagentoApiClient {
    private static final Logger log = LoggerFactory.getLogger(MagentoApiClient.class);

    private final WebClient webClient;

    public MagentoApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> Mono<T> get(String path, Map<String, String> query, Class<T> responseType) {
        return webClient.get()
            .uri(uriBuilder -> {
                var builder = uriBuilder.path(path);
                if (query != null) {
                    query.forEach(builder::queryParam);
                }
                return builder.build();
            })
            .retrieve()
            .onStatus(HttpStatusCode::isError, response -> response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(body -> Mono.error(new MagentoApiException(response.statusCode(), body))))
            .bodyToMono(responseType);
    }

    public <T> Mono<T> post(String path, Object body, Class<T> responseType) {
        return webClient.post()
            .uri(path)
            .bodyValue(body)
            .retrieve()
            .onStatus(HttpStatusCode::isError, response -> response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(bodyText -> Mono.error(new MagentoApiException(response.statusCode(), bodyText))))
            .bodyToMono(responseType);
    }

    public <T> Mono<T> put(String path, Object body, Class<T> responseType) {
        return webClient.put()
            .uri(path)
            .bodyValue(body)
            .retrieve()
            .onStatus(HttpStatusCode::isError, response -> response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(bodyText -> Mono.error(new MagentoApiException(response.statusCode(), bodyText))))
            .bodyToMono(responseType);
    }

    public <T> Mono<T> post(String path, Object body, ParameterizedTypeReference<T> responseType) {
        return webClient.post()
            .uri(path)
            .bodyValue(body)
            .retrieve()
            .onStatus(HttpStatusCode::isError, response -> response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(bodyText -> Mono.error(new MagentoApiException(response.statusCode(), bodyText))))
            .bodyToMono(responseType);
    }

    public <T> Mono<T> put(String path, Object body, ParameterizedTypeReference<T> responseType) {
        return webClient.put()
            .uri(path)
            .bodyValue(body)
            .retrieve()
            .onStatus(HttpStatusCode::isError, response -> response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(bodyText -> Mono.error(new MagentoApiException(response.statusCode(), bodyText))))
            .bodyToMono(responseType);
    }

    public void logDebug(String message, Object... args) {
        if (log.isDebugEnabled()) {
            log.debug(message, args);
        }
    }
}
