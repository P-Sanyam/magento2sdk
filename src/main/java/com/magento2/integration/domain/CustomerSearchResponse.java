package com.magento2.integration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CustomerSearchResponse {
    private List<Customer> items;

    @JsonProperty("total_count")
    private Integer totalCount;

    public List<Customer> getItems() {
        return items;
    }

    public void setItems(List<Customer> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
