# 📚 Quote API

A full-featured REST API built with Spring Boot that serves motivational and inspirational quotes. Supports full CRUD operations, clean architecture (with service and repository layers), global exception handling, Swagger UI, and in-memory seeding via H2.

---

## 🚀 Features

- `GET /api/quotes` – get all quotes
- `GET /api/quotes/random` – get a random quote
- `GET /api/quotes/{id}` – get quote by ID
- `POST /api/quotes` – add a new quote
- `PUT /api/quotes/{id}` – update a quote
- `DELETE /api/quotes/{id}` – delete a quote
- Swagger UI for exploring the API
- Global exception handling with structured error responses
- Seeded test data on startup
- JUnit & Mockito-based unit testing

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Swagger (springdoc-openapi)
- JUnit 5 + Mockito

---

## 📦 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/thejonnyboyd/quote-api.git
cd quote-api
```

### 2. Run the app
You can run it in IntelliJ or via terminal:
```bash
./mvnw spring-boot:run
```

### 3. Access the API
Base URL: http://localhost:8080/api/quotes

Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console (dev): http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

Built by @thejonnyboyd