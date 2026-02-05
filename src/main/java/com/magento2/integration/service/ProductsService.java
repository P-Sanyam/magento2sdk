package com.magento2.integration.service;

import com.magento2.integration.client.ProductsClient;
import com.magento2.integration.exception.MagentoApiException;
import com.magento2.integration.domain.MagentoProduct;
import com.magento2.integration.domain.MagentoProductRequest;
import com.magento2.integration.domain.ProductDraft;
import com.magento2.integration.domain.ProductPushResult;
import com.magento2.integration.domain.PushProductsRequest;
import com.magento2.integration.domain.PushProductsResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductsService {
    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private static final int DEFAULT_CONCURRENCY = 5;

    private final ProductsClient productsClient;

    public ProductsService(ProductsClient productsClient) {
        this.productsClient = productsClient;
    }

    public Mono<MagentoProduct> createProduct(ProductDraft draft) {
        MagentoProduct product = mapDraftToMagentoProduct(draft);
        MagentoProductRequest request = new MagentoProductRequest(product);
        return productsClient.createProduct(request);
    }

    public Mono<PushProductsResponse> pushProducts(PushProductsRequest request) {
        List<ProductDraft> drafts = request.getProducts();

        return Flux.fromIterable(drafts)
            .flatMap(this::pushSingleProduct, DEFAULT_CONCURRENCY)
            .collectList()
            .map(results -> {
                int total = results.size();
                int successCount = (int) results.stream().filter(ProductPushResult::isSuccess).count();
                int failureCount = total - successCount;
                return new PushProductsResponse(total, successCount, failureCount, results);
            });
    }

    public Mono<String> bulkCreateProductsRaw(String rawJsonArrayPayload) {
        return productsClient.bulkCreateProducts(rawJsonArrayPayload);
    }

    private Mono<ProductPushResult> pushSingleProduct(ProductDraft draft) {
        MagentoProduct product = mapDraftToMagentoProduct(draft);
        MagentoProductRequest request = new MagentoProductRequest(product);

        return productsClient.upsertProduct(draft.getSku(), request)
            .map(response -> new ProductPushResult(draft.getSku(), true, "ok"))
            .onErrorResume(ex -> {
                String message = resolveErrorMessage(ex);
                log.warn("Failed to push product sku={} message={}", draft.getSku(), message);
                return Mono.just(new ProductPushResult(draft.getSku(), false, message));
            });
    }

    private MagentoProduct mapDraftToMagentoProduct(ProductDraft draft) {
        MagentoProduct product = new MagentoProduct();
        product.setSku(draft.getSku());
        product.setName(draft.getName());
        product.setPrice(draft.getPrice());
        product.setStatus(draft.getStatus());
        product.setTypeId(draft.getTypeId());
        product.setAttributeSetId(draft.getAttributeSetId());
        product.setVisibility(draft.getVisibility());
        product.setWeight(draft.getWeight());
        return product;
    }

    private String resolveErrorMessage(Throwable ex) {
        if (ex instanceof MagentoApiException apiEx) {
            return "status=" + apiEx.getStatus() + " body=" + apiEx.getResponseBody();
        }
        return ex.getMessage() != null ? ex.getMessage() : ex.getClass().getSimpleName();
    }
}
