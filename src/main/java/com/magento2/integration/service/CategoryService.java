package com.magento2.integration.service;

import com.magento2.integration.client.CategoryClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {

    private final CategoryClient categoryClient;

    public CategoryService(CategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    public Mono<String> createCategory(String rawPayload) {
        return categoryClient.createCategory(rawPayload);
    }

    public Mono<String> getCategoryByIdRaw(Integer categoryId) {
        if (categoryId <= 0) {
            return Mono.error(new IllegalArgumentException("Category ID must be positive"));
        }
        return categoryClient.getCategoryById(categoryId);
    }

    public Mono<String> searchCategoriesByNameRaw(String name) {
        String sanitizedName = name.trim();
        if (sanitizedName.isEmpty()) {
            return Mono.error(new IllegalArgumentException("Category name cannot be empty"));
        }
        return categoryClient.searchCategoriesByName(sanitizedName);
    }
}
