package com.magento2.integration.sdk;

import com.magento2.integration.domain.CustomerDraft;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

/**
 * SDK Interface for Magento Customer operations.
 * Exposed to host applications.
 */
public interface MagentoCustomersSdk {
    Mono<String> createCustomer(@Valid CustomerDraft draft);

    Mono<String> getCustomerById(@NotNull Integer customerId);

    Mono<String> searchCustomersByEmail(@NotBlank @Email String email);
}
