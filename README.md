# Hospital Management System

This is a backend-based Hospital Management System developed using Spring Boot. The project focuses on implementing secure REST APIs using JWT authentication and performing CRUD operations on patient data.

## 🔍 Overview

The application is divided into two main modules:

### 1. Authentication Module
- User Registration
- User Login
- JWT Token Generation
- Secure API access using token

### 2. Patient Module
- Add Patient
- Get All Patients
- Get Patient by ID
- Update Patient
- Delete Patient

All patient-related APIs are secured and can only be accessed using a valid JWT token.

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Postman (for testing)

---

## 🔐 Security

- Authentication is handled using JWT
- Token is generated during login
- All protected APIs require:

  Authorization: Bearer <token>

---

## 🚀 Features

- Secure user authentication
- Stateless session management
- Clean layered architecture (Controller, Service, Repository)
- DTO-based data transfer
- Input validation using annotations
- Database integration with MySQL

---

## 📡 API Endpoints

### Auth APIs (Public)
- POST /api/auth/register
- POST /api/auth/login

### Patient APIs (Secured)
- POST /api/patients
- GET /api/patients
- GET /api/patients/{id}
- PUT /api/patients/{id}
- DELETE /api/patients/{id}

---