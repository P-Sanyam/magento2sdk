package com.magento2.integration.sdk.impl;

import com.magento2.integration.sdk.MagentoCompanySdk;
import com.magento2.integration.service.CompanyService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Component
@Validated
public class MagentoCompanySdkImpl implements MagentoCompanySdk {

    private final CompanyService companyService;

    public MagentoCompanySdkImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public Mono<String> createCompanyRaw(String rawPayload) {
        return companyService.createCompanyRaw(rawPayload);
    }

    @Override
    public Mono<String> searchCompanyByEmailRaw(String email) {
        return companyService.searchCompanyByEmailRaw(email);
    }

    @Override
    public Mono<String> assignUserToCompanyRaw(String rawPayload) {
        return companyService.assignUserToCompanyRaw(rawPayload);
    }

    @Override
    public Mono<String> getRootUserForCompanyRaw(Integer companyId) {
        return companyService.getRootUserForCompanyRaw(companyId);
    }
}
