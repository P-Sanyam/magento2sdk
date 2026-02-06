# Magento2 Integration Bot

Headless Spring Boot service that wraps Magento2 REST API calls behind Temporal-friendly endpoints. Structure mirrors the Epicor SDK layout (config, client, service, api, sdk, domain, exception).

## Requirements
- Java 17
- Maven

## Configure
Edit `src/main/resources/application.yml`:
- `magento.base-url`
- `magento.bearer-token`

## Run
```
mvn spring]-boot:run
```

## Buildd runnable JAR
```
mvn clean package
java -jar target/magento2-0.1.0.jar
```

## Temporal-facing endpoints
- `POST /api/v1/magento2/products/create`
- `POST /api/v1/magento2/products/push`
- `POST /api/v1/magento2/customers/create`
- `GET /api/v1/magento2/customers/{customerId}`
- `GET /api/v1/magento2/customers/search?email=foo@bar.com`

## SDK usage
Host apps can import the SDK config:
- `com.magento2.integration.config.MagentoSdkConfig`

Example request (products push):
```json
{
  "products": [
    {
      "sku": "SKU-1",
      "name": "Sample Product",
      "price": 19.99,
      "status": 1,
      "typeId": "simple",
      "attributeSetId": 4,
      "visibility": 4,
      "weight": 1.2
    }
  ]
}
```
# magento2sdk
