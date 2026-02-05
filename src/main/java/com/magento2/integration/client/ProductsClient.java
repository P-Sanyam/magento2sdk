package com.magento2.integration.client;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.MagentoProductRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ProductsClient {
    private final MagentoApiClient client;

    public ProductsClient(MagentoApiClient client) {
        this.client = client;
    }

    public Mono<MagentoProduct> createProduct(MagentoProductRequest request) {
        return client.post("/V1/products", request, MagentoProduct.class);
    }

    public Mono<MagentoProduct> upsertProduct(String sku, MagentoProductRequest request) {
        String path = "/V1/products/" + sku;
        return client.put(path, request, MagentoProduct.class);
    }

    public Mono<String> bulkCreateProducts(String rawJsonArrayPayload) {
        return client.post("/default/async/bulk/V1/products", rawJsonArrayPayload, String.class);
    }
}
