# Extending the SDK

## Add a New Magento Endpoint
1. Create a client wrapper in `com.magento2.integration.client`.
2. Add a service method in `com.magento2.integration.service`.
3. Add a controller endpoint in `com.magento2.integration.api` if it is Temporal-facing.
4. Update or add SDK interface + impl in `com.magento2.integration.sdk` and `sdk.impl`.
5. Add or update domain models in `com.magento2.integration.domain`.

## Example: Add Orders
- `OrdersClient` for `/V1/orders` and `/V1/orders/{id}`
- `OrdersService` for mapping and orchestration
- `OrdersController` under `/api/v1/magento2/orders`
- `MagentoOrdersSdk` interface + `MagentoOrdersSdkImpl`

## Conventions
- Keep controllers thin and delegate to services.
- Keep services focused on orchestration and mapping.
- Keep clients focused on HTTP details and endpoints.
- Keep domain models free of framework dependencies when possible.

