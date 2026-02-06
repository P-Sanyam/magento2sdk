package com.magento2.integration.client;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CompanyClient {

    private final MagentoApiClient client;

    public CompanyClient(MagentoApiClient client) {
        this.client = client;
    }

    /**
     * POST /rest/V1/awCaCompany
     */
    public Mono<String> createCompanyRaw(String rawPayload) {
        return client.post("/V1/awCaCompany", rawPayload, String.class);
    }

    /**
     * GET /rest/all/V1/awCaCompany?searchCriteria...
     */
    public Mono<String> searchCompanyByEmailRaw(String email) {
        Map<String, String> query = new HashMap<>();
        query.put("searchCriteria[filter_groups][0][filters][0][field]", "email");
        query.put("searchCriteria[filter_groups][0][filters][0][value]", email);
        query.put("searchCriteria[filter_groups][0][filters][0][condition_type]", "eq");

        return client.get("/V1/awCaCompany", query, String.class);
    }

    /**
     * POST /rest/all/V1/awCaCompanyUser/assignUserToCompany
     */
    public Mono<String> assignUserToCompanyRaw(String rawPayload) {
        return client.post("/V1/awCaCompanyUser/assignUserToCompany", rawPayload, String.class);
    }

    /**
     * GET /rest/all/V1/awCaCompanyUser/rootForCompany/{companyId}
     */
    public Mono<String> getRootUserForCompanyRaw(Integer companyId) {
        return client.get("/V1/awCaCompanyUser/rootForCompany/" + companyId, null, String.class);
    }
}
