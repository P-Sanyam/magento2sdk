package com.magento2.integration.sdk.impl;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.ProductDraft;
import com.magento2.integration.domain.PushProductsRequest;
import com.magento2.integration.domain.PushProductsResponse;
import com.magento2.integration.sdk.MagentoProductsSdk;
import com.magento2.integration.service.ProductsService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MagentoProductsSdkImpl implements MagentoProductsSdk {
    private final ProductsService productsService;

    public MagentoProductsSdkImpl(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public Mono<MagentoProduct> createProduct(ProductDraft draft) {
        return productsService.createProduct(draft);
    }

    @Override
    public Mono<PushProductsResponse> pushProducts(PushProductsRequest request) {
        return productsService.pushProducts(request);
    }

    @Override
    public Mono<String> bulkCreateProductsRaw(String rawJsonArrayPayload) {
        return productsService.bulkCreateProductsRaw(rawJsonArrayPayload);
    }

}
