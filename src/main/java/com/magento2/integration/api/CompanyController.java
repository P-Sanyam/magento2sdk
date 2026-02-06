package com.magento2.integration.api;

import com.magento2.integration.sdk.MagentoCompanySdk;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/companies")
@Validated
public class CompanyController {

    private final MagentoCompanySdk companySdk;

    public CompanyController(MagentoCompanySdk companySdk) {
        this.companySdk = companySdk;
    }

    @PostMapping("/create")
    public Mono<String> createCompany(@RequestBody @NotBlank String rawPayload) {
        return companySdk.createCompanyRaw(rawPayload);
    }

    @GetMapping("/search")
    public Mono<String> searchByEmail(@RequestParam("email") @Email String email) {
        return companySdk.searchCompanyByEmailRaw(email);
    }

    @PostMapping("/assign-user")
    public Mono<String> assignUser(@RequestBody @NotBlank String rawPayload) {
        return companySdk.assignUserToCompanyRaw(rawPayload);
    }

    @GetMapping("/{companyId}/root-user")
    public Mono<String> getRootUser(@PathVariable("companyId") @NotNull Integer companyId) {
        return companySdk.getRootUserForCompanyRaw(companyId);
    }
}
