package com.magento2.integration.sdk.impl;

import com.magento2.integration.domain.CustomerDraft;
import com.magento2.integration.sdk.MagentoCustomersSdk;
import com.magento2.integration.service.CustomersService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Component
@Validated
public class MagentoCustomersSdkImpl implements MagentoCustomersSdk {
    private final CustomersService customersService;

    public MagentoCustomersSdkImpl(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public Mono<String> createCustomer(CustomerDraft draft) {
        return Mono.defer(()->{
            validateCustomerDraft(draft);
            return customersService.createCustomer(draft);
        });
    }

    @Override
    public Mono<String> getCustomerById(Integer customerId) {
        return Mono.defer(() -> {
            validateCustomerId(customerId);
            return customersService.getCustomerById(customerId);
        });
    }

    @Override
    public Mono<String> searchCustomersByEmail(String email) {
        return Mono.defer(() -> {
            validateEmail(email);
            return customersService.searchCustomersByEmail(email);
        });
    }

    private void validateCustomerId(Integer customerId) {
        if (customerId == null || customerId < 1) {
            throw new IllegalArgumentException("customerId must be a positive integer");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email must not be blank");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("invalid email format");
        }
    }

    private void validateCustomerDraft(CustomerDraft draft) {
        if (draft == null) {
            throw new IllegalArgumentException("customer draft must not be null");
        }
        validateEmail(draft.getEmail());

        if (draft.getFirstname() == null || draft.getFirstname().isBlank()) {
            throw new IllegalArgumentException("firstname is required");
        }
        if (draft.getLastname() == null || draft.getLastname().isBlank()) {
            throw new IllegalArgumentException("lastname is required");
        }
    }
}
