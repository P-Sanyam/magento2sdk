package com.magento2.integration.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class PushProductsRequest {
    @Valid
    @NotEmpty
    private List<ProductDraft> products;

    public List<ProductDraft> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDraft> products) {
        this.products = products;
    }
}
