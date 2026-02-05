# Low-Level Design (LLD)

## Package Layout
- `com.magento2.integration.api`
  - REST controllers for Temporal workflows.
- `com.magento2.integration.service`
  - Business orchestration and mapping logic.
- `com.magento2.integration.client`
  - Magento REST client wrappers.
- `com.magento2.integration.domain`
  - POJOs for requests and responses.
- `com.magento2.integration.sdk`
  - SDK interfaces for host apps.
- `com.magento2.integration.sdk.impl`
  - SDK implementations calling the service layer.
- `com.magento2.integration.config`
  - Spring configuration and WebClient setup.
- `com.magento2.integration.exception`
  - Global exception handler and custom exceptions.
- `com.magento2.integration.auth`
  - Token provider abstraction.

## Key Classes
### API
- `ProductsController`
  - `POST /api/v1/magento2/products/create`
  - `POST /api/v1/magento2/products/push`
- `CustomersController`
  - `POST /api/v1/magento2/customers/create`
  - `GET /api/v1/magento2/customers/{customerId}`
  - `GET /api/v1/magento2/customers/search?email=`

### Service
- `ProductsService`
  - Maps `ProductDraft` to `MagentoProduct` and delegates to client.
  - Handles bulk push with concurrency and per-item error capture.
- `CustomersService`
  - Maps `CustomerDraft` to `Customer` and delegates to client.

### Client
- `MagentoApiClient`
  - WebClient wrapper with generic `get`, `post`, `put` methods.
  - Converts error responses into `MagentoApiException`.
- `ProductsClient`
  - Magento product endpoints `/V1/products` and `/V1/products/{sku}`.
- `CustomersClient`
  - Magento customer endpoints `/V1/customers` and `/V1/customers/search`.

### SDK
- `MagentoProductsSdk`, `MagentoCustomersSdk`
  - Interfaces used by host applications.
- `MagentoProductsSdkImpl`, `MagentoCustomersSdkImpl`
  - Delegates to services.

### Config
- `MagentoApiProperties`
  - `magento.base-url`, `magento.bearer-token`, `magento.timeout-seconds`.
- `WebClientConfig`
  - WebClient configuration with default headers and timeouts.
- `MagentoSdkConfig`
  - Component scan for host app imports.

### Exceptions
- `MagentoApiException`
  - Captures HTTP status + body for upstream Magento errors.
- `GlobalExceptionHandler`
  - Consistent API error response.

