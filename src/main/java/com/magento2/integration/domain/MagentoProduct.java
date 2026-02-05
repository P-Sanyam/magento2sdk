package com.magento2.integration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class MagentoProduct {
    private String sku;
    private String name;
    private BigDecimal price;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("type_id")
    private String typeId;

    @JsonProperty("attribute_set_id")
    private Integer attributeSetId;

    @JsonProperty("visibility")
    private Integer visibility;

    private BigDecimal weight;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(Integer attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
