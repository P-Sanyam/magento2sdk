package com.magento2.integration.sdk;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public interface MagentoCompanySdk {

    Mono<String> createCompanyRaw(@NotBlank String rawPayload);

    Mono<String> searchCompanyByEmailRaw(@NotBlank @Email String email);

    Mono<String> assignUserToCompanyRaw(@NotBlank String rawPayload);

    Mono<String> getRootUserForCompanyRaw(@NotNull Integer companyId);
}
