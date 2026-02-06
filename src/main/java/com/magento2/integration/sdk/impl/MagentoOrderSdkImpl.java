package com.magento2.integration.sdk.impl;

import com.magento2.integration.sdk.MagentoOrderSdk;
import com.magento2.integration.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Component
@Validated
public class MagentoOrderSdkImpl implements MagentoOrderSdk {

    private final OrderService orderService;

    public MagentoOrderSdkImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Mono<String> createOrderRaw(String rawPayload) {
        return orderService.createOrderRaw(rawPayload);
    }

    @Override
    public Mono<String> bulkCreateOrdersRaw(String rawJsonArrayPayload) {
        return orderService.bulkCreateOrdersRaw(rawJsonArrayPayload);
    }

    @Override
    public Mono<String> searchOrderByIncrementId(String incrementId) {
        return orderService.searchOrderByIncrementId(incrementId);
    }

//    @Override
//    public Mono<String> getOrderInvoice(Integer orderId) {
//        return orderService.getOrderInvoice(orderId);
//    }
}
