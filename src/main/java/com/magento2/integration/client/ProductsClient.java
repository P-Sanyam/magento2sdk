package com.magento2.integration.client;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.MagentoProductRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;
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
        String path = "/V1/products/" + UriUtils.encodePathSegment(sku, StandardCharsets.UTF_8);
        return client.put(path, request, MagentoProduct.class);
    }

    public Mono<String> bulkCreateProducts(String rawJsonArrayPayload) {
        return client.post("/async/bulk/V1/products", rawJsonArrayPayload, String.class);
    }

    public Mono<String> getAttributeSetsList() {
        Map<String, String> query = new HashMap<>();
        query.put("searchCriteria", "0");
        return client.get("/V1/products/attribute-sets/sets/list", query, String.class);
    }

    public Mono<String> getProductAttributes() {
        Map<String, String> query = new HashMap<>();
        query.put("searchCriteria[sortOrders][0][field]", "attribute_id");
        query.put("searchCriteria[sortOrders][0][direction]", "ASC");
        return client.get("/V1/products/attributes", query, String.class);
    }

    public Mono<String> getProductBySku(String sku) {
        String path = "/V1/products/" + UriUtils.encodePathSegment(sku, StandardCharsets.UTF_8);
        return client.get(path, null, String.class);
    }
}
