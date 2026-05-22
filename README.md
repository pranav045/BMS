# 🏦 Bank Management System (BMS)

A Bank Management System built with **Spring Boot** and **REST APIs**, enabling secure handling of customers, accounts, and transactions. It supports CRUD operations, authentication, and seamless integration for managing deposits, withdrawals, transfers, and account activity efficiently.

---

## 📌 Features
- Customer Management (create, update, delete, view)
- Account Management (open, close, update accounts)
- Transaction Handling (deposits, withdrawals, transfers)
- Secure Authentication & Authorization
- RESTful API endpoints for integration
- Error handling & validation

---

## 🛠️ Tech Stack
- **Backend:** Spring Boot  
- **API:** REST APIs  
- **Database:** PostgreSQL 
- **Security:** Spring Security, JWT  

---

## 📂 Project Structure

| Path                          | Description                          |
|-------------------------------|--------------------------------------|
| `src/main/java/com/bms/`      | Root package for application code    |
| ├── `controller/`             | REST Controllers (API endpoints)     |
| ├── `service/`                | Business Logic Layer                 |
| ├── `repository/`             | JPA Repositories (DB access)         |
| ├── `model/`                  | Entities (Customer, Account, etc.)   |
| ├── `dto/`                    | Data Transfer Objects                |
| ├── `exception/`              | Custom Exceptions & Handlers         |
| └── `config/`                 | Security & App Configurations        |
| `src/main/resources/`         | Application resources                |
| ├── `application.yml`         | DB & App Config                      |
| └── `schema.sql`              | Database Schema                      |
| `src/test/`                   | Unit & Integration Tests             |
| `pom.xml`                     | Maven Dependencies                   |
| `README.md`                   | Project Documentation                |

