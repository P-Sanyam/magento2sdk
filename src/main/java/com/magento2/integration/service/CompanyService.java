package com.magento2.integration.service;

import com.magento2.integration.client.CompanyClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {

    private final CompanyClient companyClient;

    public CompanyService(CompanyClient companyClient) {
        this.companyClient = companyClient;
    }

    public Mono<String> createCompanyRaw(String rawPayload) {
        return companyClient.createCompanyRaw(rawPayload);
    }

    public Mono<String> searchCompanyByEmailRaw(String email) {
        return companyClient.searchCompanyByEmailRaw(email.trim());
    }

    public Mono<String> assignUserToCompanyRaw(String rawPayload) {
        return companyClient.assignUserToCompanyRaw(rawPayload);
    }

    public Mono<String> getRootUserForCompanyRaw(Integer companyId) {
        return companyClient.getRootUserForCompanyRaw(companyId);
    }


}
