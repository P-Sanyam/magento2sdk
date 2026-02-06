package com.magento2.integration.sdk.impl;

import com.magento2.integration.sdk.MagentoShipmentSdk;
import com.magento2.integration.service.ShipmentService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Component
@Validated
public class MagentoShipmentSdkImpl implements MagentoShipmentSdk {

    private final ShipmentService shipmentService;

    public MagentoShipmentSdkImpl(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @Override
    public Mono<String> createShipmentRaw(String rawPayload) {
        return shipmentService.createShipmentRaw(rawPayload);
    }

    @Override
    public Mono<String> bulkCreateShipmentRaw(String rawJsonArrayPayload) {
        return shipmentService.bulkCreateShipmentRaw(rawJsonArrayPayload);
    }

    @Override
    public Mono<String> searchShipmentByPickTicket(String pickTicketNo) {
        return shipmentService.searchShipmentByPickTicket(pickTicketNo);
    }
}
