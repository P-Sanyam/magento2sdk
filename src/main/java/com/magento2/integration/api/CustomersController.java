package com.magento2.integration.api;

import com.magento2.integration.domain.CustomerDraft;
import com.magento2.integration.sdk.MagentoCustomersSdk;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/customers")
public class CustomersController {
    private final MagentoCustomersSdk customersSdk;

    public CustomersController(MagentoCustomersSdk customersSdk) {
        this.customersSdk = customersSdk;
    }

    @PostMapping("/create")
    public Mono<String> createCustomer(@RequestBody CustomerDraft draft) {
        return customersSdk.createCustomer(draft);
    }

    @GetMapping("/{customerId}")
    public Mono<String> getCustomer(@PathVariable("customerId") Integer customerId) {
        return customersSdk.getCustomerById(customerId);
    }

    @GetMapping("/search")
    public Mono<String> searchByEmail(@RequestParam("email") String email) {
        return customersSdk.searchCustomersByEmail(email);
    }
}
