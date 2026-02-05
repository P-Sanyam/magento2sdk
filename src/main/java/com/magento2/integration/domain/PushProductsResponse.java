package com.magento2.integration.domain;

import java.util.List;

public class PushProductsResponse {
    private int total;
    private int successCount;
    private int failureCount;
    private List<ProductPushResult> results;

    public PushProductsResponse() {
    }

    public PushProductsResponse(int total, int successCount, int failureCount, List<ProductPushResult> results) {
        this.total = total;
        this.successCount = successCount;
        this.failureCount = failureCount;
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(int failureCount) {
        this.failureCount = failureCount;
    }

    public List<ProductPushResult> getResults() {
        return results;
    }

    public void setResults(List<ProductPushResult> results) {
        this.results = results;
    }
}
