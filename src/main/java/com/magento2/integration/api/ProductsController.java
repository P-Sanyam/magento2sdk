package com.magento2.integration.api;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.ProductDraft;
import com.magento2.integration.domain.PushProductsRequest;
import com.magento2.integration.domain.PushProductsResponse;
import com.magento2.integration.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/create")
    public Mono<MagentoProduct> createProduct(@Valid @RequestBody ProductDraft draft) {
        return productsService.createProduct(draft);
    }

    @PostMapping("/push")
    public Mono<PushProductsResponse> pushProducts(@Valid @RequestBody PushProductsRequest request) {
        return productsService.pushProducts(request);
    }

    @PostMapping(value = "/async-bulk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> bulkCreateProductsRaw(@RequestBody String rawJsonArrayPayload) {
        return productsService.bulkCreateProductsRaw(rawJsonArrayPayload);
    }
}
