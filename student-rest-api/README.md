# 🎓 Student REST API — Spring Boot

A RESTful CRUD API built with **Spring Boot**, **MySQL**, and **JPA/Hibernate** to manage student records. Designed with a clean **MVC layered architecture** (Controller → Service → Repository), input validation, and global exception handling.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot 3.2 | Backend framework |
| Spring Data JPA | ORM / Database layer |
| MySQL | Relational database |
| Maven | Build tool |
| Postman | API testing |

---

## 📁 Project Structure

```
student-rest-api/
├── src/
│   └── main/
│       ├── java/com/rishideep/studentapi/
│       │   ├── controller/       # REST endpoints
│       │   ├── service/          # Business logic
│       │   ├── repository/       # JPA database layer
│       │   ├── model/            # Student entity
│       │   └── exception/        # Custom exceptions & global handler
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

---

## ⚙️ Setup & Run

### Prerequisites
- Java 17+
- MySQL installed and running
- Maven

### Step 1 — Create Database
```sql
CREATE DATABASE studentdb;
```

### Step 2 — Configure Database
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password_here
```

### Step 3 — Run the Application
```bash
mvn spring-boot:run
```

Server starts at: `http://localhost:8080`

---

## 📡 API Endpoints

### Base URL: `/api/students`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| GET | `/api/students/email/{email}` | Get student by email |
| GET | `/api/students/branch/{branch}` | Get students by branch |
| GET | `/api/students/year/{year}` | Get students by year |
| GET | `/api/students/cgpa/{cgpa}` | Get students with CGPA ≥ value |
| POST | `/api/students` | Create a new student |
| PUT | `/api/students/{id}` | Update an existing student |
| DELETE | `/api/students/{id}` | Delete a student |

---

## 📋 Sample Request & Response

### Create Student (POST `/api/students`)

**Request Body:**
```json
{
  "name": "Vignesh Rishideep",
  "email": "vignesh@example.com",
  "branch": "Computer Science",
  "year": 4,
  "cgpa": 8.5
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Vignesh Rishideep",
  "email": "vignesh@example.com",
  "branch": "Computer Science",
  "year": 4,
  "cgpa": 8.5
}
```

### Error Response (404 Not Found):
```json
{
  "timestamp": "2026-05-20T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found with ID: 99"
}
```

---

## ✅ Features

- Full **CRUD operations** (Create, Read, Update, Delete)
- **Input validation** using Jakarta Bean Validation (`@NotBlank`, `@Email`, `@Min`, `@Max`)
- **Global Exception Handling** with proper HTTP status codes
- **Custom query methods** — filter by branch, year, CGPA
- **Clean layered architecture** — Controller, Service, Repository separation
- **Auto table creation** via Hibernate DDL

---

## 🧪 Testing with Postman

Import the base URL `http://localhost:8080` and test endpoints using the table above. Set `Content-Type: application/json` in headers for POST and PUT requests.

---

## 👨‍💻 Author

**Vejju Sai Naga Venkata Vignesh Rishideep**  
B.Tech CSE — VIT-AP University (2026)  
📧 vejjurishideep@gmail.com  
🔗 [LinkedIn](https://linkedin.com/in/rishi-deep-88694a226)  
🐙 [GitHub](https://github.com/Ri460)
