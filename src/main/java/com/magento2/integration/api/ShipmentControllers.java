package com.magento2.integration.api;

import com.magento2.integration.sdk.MagentoShipmentSdk;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/magento2/shipments")
@Validated
public class ShipmentControllers {

    private final MagentoShipmentSdk shipmentSdk;

    public ShipmentControllers(MagentoShipmentSdk shipmentSdk) {
        this.shipmentSdk = shipmentSdk;
    }

    @GetMapping("/search")
    public Mono<String> searchByPickTicket(@RequestParam("pickTicketNo") @NotBlank String pickTicketNo) {
        return shipmentSdk.searchShipmentByPickTicket(pickTicketNo);
    }

    @PostMapping
    public Mono<String> createShipment(@RequestBody @NotBlank String rawPayload) {
        return shipmentSdk.createShipmentRaw(rawPayload);
    }

    @PostMapping("/bulk")
    public Mono<String> bulkCreateShipment(@RequestBody @NotBlank String rawJsonArrayPayload) {
        return shipmentSdk.bulkCreateShipmentRaw(rawJsonArrayPayload);
    }
}
