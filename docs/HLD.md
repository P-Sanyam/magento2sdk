# High-Level Design (HLD)

## Purpose
A headless Spring Boot service that wraps Magento2 REST API endpoints in a Temporal-friendly REST facade and exposes an SDK interface for host applications.

## Goals
- Provide non-blocking Magento API access via WebClient.
- Offer a clean, layered architecture similar to the Epicor SDK.
- Keep domain models separate from transport and infrastructure concerns.
- Expose REST endpoints suitable for Temporal workflows.

## Non-Goals
- No UI.
- No CRUD admin console.
- No persistence layer in this version (can be added later).

## Architecture Overview
- **API Layer**: REST controllers for Temporal workflows.
- **Service Layer**: Orchestrates business flow and error handling.
- **Client Layer**: Magento REST client wrappers.
- **Domain Layer**: Request/response and domain models.
- **SDK Layer**: Interfaces and implementations used by host apps.
- **Config Layer**: Spring configuration and WebClient setup.
- **Exception Layer**: Consistent error handling.

## Core Integrations
- Magento2 REST API via WebClient
- Temporal workflows via REST calls into `/api/v1/magento2/*`

## Key Runtime Dependencies
- Java 17
- Spring Boot 3.x
- Spring WebFlux (WebClient)
- Jackson
- SLF4J

