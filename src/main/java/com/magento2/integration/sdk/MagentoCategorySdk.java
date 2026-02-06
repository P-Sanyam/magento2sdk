package com.magento2.integration.sdk;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public interface MagentoCategorySdk {

    Mono<String> createCategory(@NotBlank String rawCreateCategoryPayload);

    Mono<String> getCategoryByIdRaw(@NotNull Integer categoryId);

    Mono<String> searchCategoriesByNameRaw(@NotNull String name);
}
