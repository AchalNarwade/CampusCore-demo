# CampusCore 🎓

CampusCore is a full-stack CRUD web application built using Spring Boot, PostgreSQL, and a simple HTML/CSS/JavaScript frontend. The project demonstrates end-to-end integration of frontend, backend, database, and cloud deployment.

---

## 🚀 Live Deployment

Frontend (Netlify):  https://campuscoree.netlify.app/
Backend (Render): https://campuscore-demo.onrender.com
Database: PostgreSQL (Hosted on Render)

---

## ✨ Features

- Create, Read, Update, Delete (CRUD) operations
- REST API built with Spring Boot
- PostgreSQL database integration using Spring Data JPA
- CORS enabled for frontend-backend communication
- Backend deployed on Render
- Frontend deployed on Netlify

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
- Maven

Database:
- PostgreSQL (Render)

Deployment:
- Render (Backend + Database)
- Netlify (Frontend)

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
└── README.md

---

## ⚙️ API Endpoints

GET     /students        → Get all students  
POST    /students        → Add new student  
PUT     /students/{id}   → Update student  
DELETE  /students/{id}   → Delete student  

---

## 🧪 How to Run Locally

### Clone Repository
git clone https://github.com/your-username/CampusCore.git

---

### Setup Database
CREATE DATABASE campuscore;

---

### Configure application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/campuscore  
spring.datasource.username=your_username  
spring.datasource.password=your_password  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  

---

### Run Backend
cd backend  
mvn spring-boot:run  

Backend runs at:
http://localhost:8080

---

### Run Frontend
Open:
frontend/index.html

---

## ☁️ Deployment Info

Backend hosted on Render  
Database hosted on Render PostgreSQL  
Frontend hosted on Netlify  
CORS enabled for API communication  

---

## 📌 What I Learned

- Building REST APIs using Spring Boot
- Connecting Spring Boot with PostgreSQL
- Full-stack integration (frontend + backend + DB)
- Deploying backend on Render
- Deploying frontend on Netlify
- Handling CORS issues in real projects

---

## 👨‍💻 Author

Achal Narwade

---

## 📌 Project Status

Backend CRUD completed  
Database integration completed  
Frontend connected successfully  
Deployed on cloud  
UI improvements pending  
Next upgrade: JWT Authentication system