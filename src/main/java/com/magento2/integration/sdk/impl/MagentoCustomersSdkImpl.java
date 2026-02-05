package com.magento2.integration.sdk.impl;

import com.magento2.integration.domain.CustomerDraft;
import com.magento2.integration.sdk.MagentoCustomersSdk;
import com.magento2.integration.service.CustomersService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MagentoCustomersSdkImpl implements MagentoCustomersSdk {
    private final CustomersService customersService;

    public MagentoCustomersSdkImpl(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public Mono<String> createCustomer(CustomerDraft draft) {
        return customersService.createCustomer(draft);
    }

    @Override
    public Mono<String> getCustomerById(Integer customerId) {
        return customersService.getCustomerById(customerId);
    }

    @Override
    public Mono<String> searchCustomersByEmail(String email) {
        return customersService.searchCustomersByEmail(email);
    }
}
