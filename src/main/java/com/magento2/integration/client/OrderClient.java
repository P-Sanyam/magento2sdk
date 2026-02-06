package com.magento2.integration.client;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderClient {

    private final MagentoApiClient client;

    public OrderClient(MagentoApiClient client) {
        this.client = client;
    }

    // Create single order
    public Mono<String> createOrder(String rawPayload) {
        return client.post("/V1/orders", rawPayload, String.class);
    }

    // Bulk async create orders
    public Mono<String> bulkCreateOrders(String rawJsonArrayPayload) {
        return client.post("/async/bulk/V1/orders", rawJsonArrayPayload, String.class);
    }

    // Search order by increment_id
    public Mono<String> searchOrderByIncrementId(String incrementId) {
        Map<String, String> query = new HashMap<>();
        query.put("searchCriteria[filter_groups][0][filters][0][field]", "increment_id");
        query.put("searchCriteria[filter_groups][0][filters][0][value]", incrementId);
        query.put("searchCriteria[filter_groups][0][filters][0][condition_type]", "eq");

        return client.get("/V1/orders", query, String.class);
    }

    // Get invoice by orderId
//    public Mono<String> getOrderInvoice(Integer orderId) {
//        Map<String, String> query = new HashMap<>();
//        query.put("searchCriteria[filter_groups][0][filters][0][field]", "order_id");
//        query.put("searchCriteria[filter_groups][0][filters][0][value]", String.valueOf(orderId));
//        query.put("searchCriteria[filter_groups][0][filters][0][condition_type]", "eq");
//
//        return client.get("V1/invoices", query, String.class);
//    }
}
