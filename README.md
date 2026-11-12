# Payment Export Pipeline

## Overview

A small payment export pipeline built using Java 21,
Spring Boot, Spring Batch and PostgreSQL.

The application retrieves payment records, selects
payments with ALLOCATED status and exports them through
a REST API.

## Technologies

- Java 21
- Spring Boot
- Spring Batch
- Spring Data JPA
- PostgreSQL
- Flyway
- Docker Compose
- Maven

## Prerequisites

- Java 21 (for local development)
- Docker Desktop
- Postman (optional)
- DBeaver (optional)

## Start the application

Run:

docker compose up --build -d

Check services:

docker compose ps

## API endpoints

GET /payments

Retrieves all payment records.

POST /exported-payments

Stores an exported payment.

POST /batch/run

Starts the payment export batch job.

## Run the batch job

Send a POST request to:

http://localhost:8080/batch/run

The batch job:
1. Calls GET /payments.
2. Selects ALLOCATED payments.
3. Calls POST /exported-payments
   for each selected payment.

## Verify exported payments

Connect to PostgreSQL using DBeaver:

Host: localhost
Port: 5432
Database: payment_db
Username: postgres

Execute:

SELECT * FROM exported_payments;

Expected result:

PAY1001
PAY1003
PAY1005

## Stop the application

Run:

docker compose down

Database data is preserved in the Docker volume.

# Diagram


flowchart TD
A["Docker Compose"] --> B["PostgreSQL Database"]
A --> C["Spring Boot Application"]

    B --> D[("payments table")]
    B --> E[("exported_payments table")]

    C --> F["GET /payments"]
    F --> D
    D --> G["Return payment records"]

    G --> H["Spring Batch Job"]
    H --> I["Filter payments"]
    I --> J{"Status = ALLOCATED?"}

    J -->|No| K["Skip payment"]
    J -->|Yes| L["Prepare export request"]

    L --> M["POST /exported-payments"]
    M --> N["Validate request"]
    N --> O["Save exported payment"]
    O --> E

    E --> P["Export record stored"]
    P --> Q["Job completes"]

    K --> Q

