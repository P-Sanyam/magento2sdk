package com.magento2.integration.client;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class CategoryClient {

    private final MagentoApiClient magentoApiClient;

    public CategoryClient(MagentoApiClient magentoApiClient) {
        this.magentoApiClient = magentoApiClient;
    }

    // CREATE CATEGORY (POST /V1/categories)
    public Mono<String> createCategory(String rawPayload) {
        return magentoApiClient.post(
                "/V1/categories",
                rawPayload,
                String.class
        );
    }

    // GET CATEGORY BY ID (GET /V1/categories/{id})
    public Mono<String> getCategoryById(Integer categoryId) {
        return magentoApiClient.get(
                "/V1/categories/" + categoryId,
                null,
                String.class
        );
    }

    // SEARCH CATEGORY BY NAME
    public Mono<String> searchCategoriesByName(String name) {
        Map<String, String> queryParams = Map.of(
                "searchCriteria[filterGroups][0][filters][0][field]", "name",
                "searchCriteria[filterGroups][0][filters][0][value]", name,
                "searchCriteria[filterGroups][0][filters][0][conditionType]", "eq"
        );

        return magentoApiClient.get(
                "/V1/categories/list",
                queryParams,
                String.class
        );
    }
}
