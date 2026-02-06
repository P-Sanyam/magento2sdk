package com.magento2.integration.api;

import com.magento2.integration.sdk.MagentoCategorySdk;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/categories")
@Validated
public class CategoryControllers {

    private final MagentoCategorySdk categorySdk;

    public CategoryControllers(MagentoCategorySdk categorySdk) {
        this.categorySdk = categorySdk;
    }

    @PostMapping
    public Mono<String> createCategory(@RequestBody String rawPayload) {
        return categorySdk.createCategory(rawPayload);
    }

    @GetMapping("/{id}")
    public Mono<String> getCategoryById(@PathVariable("id") @NotNull Integer id) {
        return categorySdk.getCategoryByIdRaw(id);
    }

    @GetMapping("/search")
    public Mono<String> searchByName(@RequestParam("name") @NotBlank String name) {
        return categorySdk.searchCategoriesByNameRaw(name);
    }
}
