package com.magento2.integration.sdk;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.ProductDraft;
import com.magento2.integration.domain.PushProductsRequest;
import com.magento2.integration.domain.PushProductsResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import reactor.core.publisher.Mono;

/**
 * SDK Interface for Magento Product operations.
 * Exposed to host applications.
 */

public interface MagentoProductsSdk {
    Mono<MagentoProduct> createProduct(@Valid ProductDraft draft);

    Mono<PushProductsResponse> pushProducts(@Valid PushProductsRequest request);

    Mono<String> bulkCreateProductsRaw(@NotBlank String rawJsonArrayPayload);

    Mono<String> getAttributeSetsListRaw();

    Mono<String> getProductAttributesRaw();

    Mono<String> getProductBySkuRaw(@NotBlank @Pattern(regexp = "^[^/\\\\\\s]+$") String sku);

}
