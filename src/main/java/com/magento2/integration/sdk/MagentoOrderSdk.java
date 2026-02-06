package com.magento2.integration.sdk;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public interface MagentoOrderSdk {

    Mono<String> createOrderRaw(@NotBlank String rawPayload);

    Mono<String> bulkCreateOrdersRaw(@NotBlank String rawJsonArrayPayload);

    Mono<String> searchOrderByIncrementId(@NotBlank String incrementId);

//    Mono<String> getOrderInvoice(@NotNull Integer orderId);
}
