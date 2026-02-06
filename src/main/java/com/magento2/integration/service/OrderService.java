package com.magento2.integration.service;

import com.magento2.integration.client.OrderClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderClient orderClient;

    public OrderService(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public Mono<String> createOrderRaw(String rawPayload) {
        validatePayload(rawPayload);
        return orderClient.createOrder(rawPayload);
    }

    public Mono<String> bulkCreateOrdersRaw(String rawJsonArrayPayload) {
        validatePayload(rawJsonArrayPayload);
        return orderClient.bulkCreateOrders(rawJsonArrayPayload);
    }

    public Mono<String> searchOrderByIncrementId(String incrementId) {
        if (incrementId == null || incrementId.isBlank()) {
            throw new IllegalArgumentException("incrementId must not be blank");
        }
        return orderClient.searchOrderByIncrementId(incrementId.trim());
    }

//    public Mono<String> getOrderInvoice(Integer orderId) {
//        if (orderId == null || orderId < 1) {
//            throw new IllegalArgumentException("orderId must be positive");
//        }
//        return orderClient.getOrderInvoice(orderId);
//    }

    private void validatePayload(String payload) {
        if (payload == null || payload.isBlank()) {
            throw new IllegalArgumentException("Request body must not be empty");
        }
    }
}
