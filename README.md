# CampusCore 🎓 (Demo Project)

CampusCore is a simple CRUD-based full-stack demo application built using Spring Boot, PostgreSQL, and basic HTML/CSS/JavaScript frontend.

The project demonstrates how frontend, backend, and database work together in a full-stack architecture.

---

## 🚀 Features

- Basic CRUD operations (Create, Read, Update, Delete)
- REST API built using Spring Boot
- PostgreSQL database integration
- Frontend connected to backend APIs
- Simple UI using HTML, CSS, JavaScript

---

## 🛠️ Tech Stack

Frontend:
- HTML
- CSS
- JavaScript

Backend:
- Java
- Spring Boot
- Spring Web
- Spring Data JPA

Database:
- PostgreSQL

---

## 📁 Project Structure

CampusCore/
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── application.properties
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── .gitignore
└── README.md

---

## ⚙️ How to Run the Project

### 1. Clone the repository
git clone https://github.com/your-username/CampusCore.git

---

### 2. Setup PostgreSQL Database

Create database:
CREATE DATABASE campuscore;

Update backend configuration:

spring.datasource.url=jdbc:postgresql://localhost:5432/campuscore
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

### 3. Run Backend (Spring Boot)

cd backend
mvn spring-boot:run

Backend runs on:
http://localhost:8080

---

### 4. Run Frontend

Open:
frontend/index.html

in your browser.

Frontend communicates with backend APIs.

---

## 🧠 What This Project Demonstrates

- REST API development using Spring Boot
- PostgreSQL database integration with JPA
- Frontend to backend API communication
- Full-stack application flow

---

## 📌 Project Type

- Demo CRUD Project
- Learning / Academic Project
- Full-stack integration practice

---

## 👨‍💻 Author

Achal Narwade

---

## 📌 Status

- Backend CRUD APIs working
- PostgreSQL connected
- Frontend connected to backend
- UI improvements pending
- Deployment pending
