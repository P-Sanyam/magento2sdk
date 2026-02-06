package com.magento2.integration.api;

import com.magento2.integration.domain.CustomerDraft;
import com.magento2.integration.service.CustomersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/customers")
@Validated
public class CustomersController {
    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @PostMapping("/create")
    public Mono<String> createCustomer(@Valid @RequestBody CustomerDraft draft) {
        return customersService.createCustomer(draft);
    }

    @GetMapping("/{customerId}")
    public Mono<String> getCustomer(@PathVariable("customerId") Integer customerId) {
        return customersService.getCustomerById(customerId);
    }

    @GetMapping("/search")
    public Mono<String> searchByEmail(@RequestParam("email") @NotBlank @Email String email) {
        return customersService.searchCustomersByEmail(email);
    }
}
