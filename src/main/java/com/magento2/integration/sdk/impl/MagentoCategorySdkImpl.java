package com.magento2.integration.sdk.impl;

import com.magento2.integration.sdk.MagentoCategorySdk;
import com.magento2.integration.service.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Component
@Validated
public class MagentoCategorySdkImpl implements MagentoCategorySdk {

    private final CategoryService categoryService;

    public MagentoCategorySdkImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Mono<String> createCategory(String rawCreateCategoryPayload) {
        return categoryService.createCategory(rawCreateCategoryPayload);
    }

    @Override
    public Mono<String> getCategoryByIdRaw(Integer categoryId) {
        return categoryService.getCategoryByIdRaw(categoryId);
    }

    @Override
    public Mono<String> searchCategoriesByNameRaw(String name) {
        return categoryService.searchCategoriesByNameRaw(name);
    }
}
