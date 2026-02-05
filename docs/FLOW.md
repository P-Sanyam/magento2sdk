# Flow Reference

## Create Product Flow
1. Temporal calls `POST /api/v1/magento2/products/create` with `ProductDraft`.
2. `ProductsController` validates input and calls `ProductsService`.
3. `ProductsService` maps draft -> `MagentoProductRequest`.
4. `ProductsClient` calls Magento `/V1/products`.
5. Response is returned to Temporal.

## Push Products (Bulk) Flow
1. Temporal calls `POST /api/v1/magento2/products/push` with list of drafts.
2. `ProductsService` processes items concurrently.
3. Each product is upserted using `/V1/products/{sku}`.
4. Service returns summary counts and per-item result.

## Create Customer Flow
1. Temporal calls `POST /api/v1/magento2/customers/create`.
2. `CustomersService` maps draft -> `CustomerRequest`.
3. `CustomersClient` calls Magento `/V1/customers`.

## Search Customer Flow
1. Temporal calls `GET /api/v1/magento2/customers/search?email=`.
2. `CustomersClient` builds search criteria query params.
3. Magento returns `CustomerSearchResponse`.

## Error Handling
- Magento REST errors are wrapped into `MagentoApiException`.
- `GlobalExceptionHandler` formats a consistent error payload.
