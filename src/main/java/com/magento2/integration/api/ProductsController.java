package com.magento2.integration.api;

import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.ProductDraft;
import com.magento2.integration.domain.PushProductsRequest;
import com.magento2.integration.domain.PushProductsResponse;
import com.magento2.integration.sdk.MagentoProductsSdk;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/products")
public class ProductsController {
    private final MagentoProductsSdk productsSdk;

    public ProductsController(MagentoProductsSdk productsSdk) {
        this.productsSdk = productsSdk;
    }

    @PostMapping("/create")
    public Mono<MagentoProduct> createProduct(@RequestBody ProductDraft draft) {
        return productsSdk.createProduct(draft);
    }

    @PostMapping("/push")
    public Mono<PushProductsResponse> pushProducts(@RequestBody PushProductsRequest request) {
        return productsSdk.pushProducts(request);
    }

    @PostMapping(value = "/async-bulk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> bulkCreateProductsRaw(@RequestBody String rawJsonArrayPayload) {
        return productsSdk.bulkCreateProductsRaw(rawJsonArrayPayload);
    }

    @GetMapping(value = "/attribute-sets", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getAttributeSetsListRaw() {
        return productsSdk.getAttributeSetsListRaw();
    }

    @GetMapping(value = "/attributes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getProductAttributesRaw() {
        return productsSdk.getProductAttributesRaw();
    }

    @GetMapping(value = "/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getProductBySkuRaw(@PathVariable("sku") String sku) {
        return productsSdk.getProductBySkuRaw(sku);
    }
}
