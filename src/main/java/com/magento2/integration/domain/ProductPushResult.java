package com.magento2.integration.domain;

public class ProductPushResult {
    private String sku;
    private boolean success;
    private String message;

    public ProductPushResult() {
    }

    public ProductPushResult(String sku, boolean success, String message) {
        this.sku = sku;
        this.success = success;
        this.message = message;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
