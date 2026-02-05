package com.magento2.integration.sdk;

import com.magento2.integration.domain.CustomerDraft;
import reactor.core.publisher.Mono;

/**
 * SDK Interface for Magento Customer operations.
 * Exposed to host applications.
 */
public interface MagentoCustomersSdk {
    Mono<String> createCustomer(CustomerDraft draft);

    Mono<String> getCustomerById(Integer customerId);

    Mono<String> searchCustomersByEmail(String email);
}
