package com.magento2.integration.service;

import com.magento2.integration.client.CustomersClient;
import com.magento2.integration.domain.Customer;
import com.magento2.integration.domain.CustomerDraft;
import com.magento2.integration.domain.CustomerRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomersService {
    private final CustomersClient customersClient;

    public CustomersService(CustomersClient customersClient) {
        this.customersClient = customersClient;
    }

    public Mono<String> createCustomer(CustomerDraft draft) {
        Customer customer = mapDraftToCustomer(draft);
        CustomerRequest request = new CustomerRequest(customer);
        return customersClient.createCustomer(request);
    }

    public Mono<String> getCustomerById(Integer customerId) {
        return customersClient.getCustomerById(customerId);
    }

    public Mono<String> searchCustomersByEmail(String email) {
//        String normalizedEmail = email.trim().toLowerCase();
        return customersClient.searchCustomersByEmail(email);
    }

    private Customer mapDraftToCustomer(CustomerDraft draft) {
        Customer customer = new Customer();
        customer.setEmail(draft.getEmail());
        customer.setFirstname(draft.getFirstname());
        customer.setLastname(draft.getLastname());
        customer.setWebsiteId(draft.getWebsiteId());
        customer.setStoreId(draft.getStoreId());
        customer.setAddresses(draft.getAddresses());
        return customer;
    }
}
