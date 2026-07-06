# 📚 Students API

A clean and fully deployed RESTful Students Management API built with Spring Boot 3, PostgreSQL, and Docker, hosted on Render.
Provides endpoints for creating, updating, listing, and deleting student records.

## 🚀 Live API

**Base URL**
`https://students-api-satb.onrender.com`

**Endpoints**
- `GET /api/students`
- `POST /api/students`
- `PUT /api/students/{id}`
- `DELETE /api/students/{id}`

**Swagger UI**
`https://students-api-satb.onrender.com/swagger-ui.html`

## 🧱 Tech Stack
- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL (Render)
- Docker (Multi‑stage build)
- Maven
- Swagger / OpenAPI

## 📦 Features
- Add new students
- Update existing students
- Delete students
- Fetch all students
- Fetch student by ID
- Global exception handling
- DTO‑based request/response
- CORS enabled for frontend integration

## 🗂️ Project Structure
```text
students-api/
 ├── src/main/java/tz/ac/suza/wt/students_api
 │ ├── controller
 │ ├── service
 │ ├── repository
 │ ├── entity
 │ ├── dto
 │ ├── exception
 │ └── config
 ├── src/main/resources
 │ └── application.properties
 ├── Dockerfile
 ├── pom.xml
 └── README.md
```

## ⚙️ Configuration

### application.properties
```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

springdoc.swagger-ui.path=/swagger-ui.html
```

### Render Environment Variables
| Key | Value |
|---|---|
| DATABASE_URL | jdbc:postgresql://<render-host>:5432/studentsdb_fa03 |
| DATABASE_USERNAME | studentsdb_fa03_user |
| DATABASE_PASSWORD | your password |

## 🐳 Dockerfile
```dockerfile
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -e -DskipTests clean package

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 🌐 Deployment (Render)
1. Push project to GitHub
2. Create a Web Service on Render
3. Select Docker runtime
4. Add environment variables
5. Deploy

## 🔗 Frontend Integration
Use the deployed API:
```javascript
const API = "https://students-api-satb.onrender.com/api/students";
```
**Supports:**
- GET all students
- POST new student
- DELETE student
- PUT update student

## 👨‍💻 Author
**Abdulkadir Bakar Mbwana**
Computer Science — SUZA
Backend Developer | Cybersecurity Enthusiast
