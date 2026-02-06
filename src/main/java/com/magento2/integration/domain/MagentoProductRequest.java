package com.magento2.integration.domain;

public class MagentoProductRequest {
    private MagentoProduct product;

    public MagentoProductRequest() {
    }

    public MagentoProductRequest(MagentoProduct product) {
        this.product = product;
    }

    public MagentoProduct getProduct() {
        return product;
    }

    public void setProduct(MagentoProduct product) {
        this.product = product;
    }
}
