# paymentExport

Installation in system :

[x] Java JDK 21
[x] IntelliJ IDEA
[x] Docker Desktop
[x] Git
[x] Postman
[x] DBeaver Community (will be used to view and verify PostgreSQL data)

# Java

    java -version : java version "17.0.6" 2023-01-17 LTS

# Docker 

    docker --version : Docker version 28.5.1, build e180ab8

    docker compose version : Docker Compose version v2.40.2-desktop.1

# PostgreSQL configuration

### Check whether the container is running:
    docker ps
### Create 
    docker run --name payment-postgres \
    -e POSTGRES_DB=payment_db \
    -e POSTGRES_USER=postgresAnwesha \
    -e POSTGRES_PASSWORD=postgresRoot \
    -p 5432:5432 \
    -d postgres:18
This command does five things:
1. Downloads the PostgreSQL 16 image if it isn't already available.
2. Creates a container named payment-postgres.
3. Creates a database named payment_db.
4. Creates the username postgres and password postgres123.
5. Exposes PostgreSQL on port 5432 on your Mac.

### Check PostgreSQL logs:
    docker logs payment-postgres



