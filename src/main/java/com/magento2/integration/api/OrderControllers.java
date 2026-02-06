    package com.magento2.integration.api;

    import com.magento2.integration.sdk.MagentoOrderSdk;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.*;
    import reactor.core.publisher.Mono;

    @RestController
    @RequestMapping("/api/v1/magento2/orders")
    @Validated
    public class OrderControllers {

        private final MagentoOrderSdk orderSdk;

        public OrderControllers(MagentoOrderSdk orderSdk) {
            this.orderSdk = orderSdk;
        }

        @PostMapping
        public Mono<String> createOrder(@RequestBody @NotBlank String rawPayload) {
            return orderSdk.createOrderRaw(rawPayload);
        }

        @PostMapping("/bulk")
        public Mono<String> bulkCreateOrders(@RequestBody @NotBlank String rawJsonArrayPayload) {
            return orderSdk.bulkCreateOrdersRaw(rawJsonArrayPayload);
        }

        @GetMapping("/search")
        public Mono<String> searchByIncrementId(@RequestParam("incrementId") @NotBlank String incrementId) {
            return orderSdk.searchOrderByIncrementId(incrementId);
        }

//        @GetMapping("/{orderId}/invoice")
//        public Mono<String> getInvoice(@PathVariable("orderId") @NotNull Integer orderId) {
//            return orderSdk.getOrderInvoice(orderId);
//        }
    }
