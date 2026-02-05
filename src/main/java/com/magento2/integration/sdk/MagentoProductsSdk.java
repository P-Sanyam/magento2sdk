package com.magento2.integration.sdk;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.ProductDraft;
import com.magento2.integration.domain.PushProductsRequest;
import com.magento2.integration.domain.PushProductsResponse;
import reactor.core.publisher.Mono;

/**
 * SDK Interface for Magento Product operations.
 * Exposed to host applications.
 */
public interface MagentoProductsSdk {
    Mono<MagentoProduct> createProduct(ProductDraft draft);

    Mono<PushProductsResponse> pushProducts(PushProductsRequest request);

    Mono<String> bulkCreateProductsRaw(String rawJsonArrayPayload);

}
