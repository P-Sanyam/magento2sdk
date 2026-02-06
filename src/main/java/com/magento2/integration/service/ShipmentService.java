package com.magento2.integration.service;

import com.magento2.integration.client.ShipmentClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ShipmentService {

    private final ShipmentClient shipmentClient;

    public ShipmentService(ShipmentClient shipmentClient) {
        this.shipmentClient = shipmentClient;
    }

    public Mono<String> createShipmentRaw(String rawPayload) {
        validatePayload(rawPayload);
        return shipmentClient.createShipment(rawPayload);
    }

    public Mono<String> bulkCreateShipmentRaw(String rawJsonArrayPayload) {
        validatePayload(rawJsonArrayPayload);
        return shipmentClient.bulkCreateShipment(rawJsonArrayPayload);
    }

    public Mono<String> searchShipmentByPickTicket(String pickTicketNo) {
        if (pickTicketNo == null || pickTicketNo.isBlank()) {
            throw new IllegalArgumentException("pickTicketNo must not be blank");
        }
        return shipmentClient.searchShipmentByPickTicket(pickTicketNo.trim());
    }

    private void validatePayload(String payload) {
        if (payload == null || payload.isBlank()) {
            throw new IllegalArgumentException("Request body must not be empty");
        }
    }
}
