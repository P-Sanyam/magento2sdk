# Architecture

## Layering
- **API** depends on **Service**
- **Service** depends on **Client** and **Domain**
- **Client** depends on **Config** and **Domain**
- **SDK** depends on **Service**
- **Config** is dependency-free and used by runtime

## Dependency Direction
`api -> service -> client -> external Magento API`

Domain objects are shared across layers but do not depend on any service or client.

## Configuration
- `MagentoApiProperties` loads `magento.*` settings.
- `WebClientConfig` builds a shared WebClient with bearer auth.
- `MagentoSdkConfig` exposes SDK components for host apps.

## Runtime Boundaries
- External: Magento2 REST API
- Internal: SDK and REST endpoints
- Consumers: Temporal workflows or host apps via SDK

