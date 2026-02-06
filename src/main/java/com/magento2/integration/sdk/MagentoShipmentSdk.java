package com.magento2.integration.sdk;

import jakarta.validation.constraints.NotBlank;
import reactor.core.publisher.Mono;

public interface MagentoShipmentSdk {

    Mono<String> createShipmentRaw(@NotBlank String rawPayload);

    Mono<String> bulkCreateShipmentRaw(@NotBlank String rawJsonArrayPayload);

    Mono<String> searchShipmentByPickTicket(@NotBlank String pickTicketNo);
}
