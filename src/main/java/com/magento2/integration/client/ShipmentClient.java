package com.magento2.integration.client;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ShipmentClient {

    private final MagentoApiClient client;

    public ShipmentClient(MagentoApiClient client) {
        this.client = client;
    }

    public Mono<String> searchShipmentByPickTicket(String pickTicketNo) {
        Map<String, String> query = new HashMap<>();
        query.put("searchCriteria[filterGroups][0][filters][0][field]", "pick_ticket");
        query.put("searchCriteria[filterGroups][0][filters][0][value]", pickTicketNo);
        query.put("searchCriteria[filterGroups][0][filters][0][conditionType]", "eq");

        return client.get("/V1/shipments", query, String.class);
    }

    public Mono<String> createShipment(String rawPayload) {
        return client.post("/V1/shipment", rawPayload, String.class);
    }

    public Mono<String> bulkCreateShipment(String rawJsonArrayPayload) {
        return client.post("/async/bulk/V1/shipment", rawJsonArrayPayload, String.class);
    }
}
