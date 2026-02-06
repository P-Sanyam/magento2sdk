package com.magento2.integration.client;

import com.magento2.integration.domain.CustomerRequest;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomersClient {
    private final MagentoApiClient client;

    public CustomersClient(MagentoApiClient client) {
        this.client = client;
    }

    public Mono<String> createCustomer(CustomerRequest request) {
        return client.post("/V1/customers", request, String.class);
    }

    public Mono<String> getCustomerById(Integer customerId) {
        return client.get("/V1/customers/" + customerId, null, String.class);
    }

    public Mono<String> searchCustomersByEmail(String email) {
        Map<String, String> query = new HashMap<>();
        query.put("searchCriteria[filter_groups][0][filters][0][field]", "email");
        query.put("searchCriteria[filter_groups][0][filters][0][value]", email);
        query.put("searchCriteria[filter_groups][0][filters][0][condition_type]", "eq");
        return client.get("/V1/customers/search", query, String.class);
    }
}
