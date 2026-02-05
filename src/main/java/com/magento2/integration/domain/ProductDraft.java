package com.magento2.integration.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDraft {
    @NotBlank
    private String sku;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    private Integer status = 1;
    private String typeId = "simple";
    private Integer attributeSetId = 4;
    private Integer visibility = 4;
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
