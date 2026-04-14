📓 Journal App (Spring Boot + JWT + MongoDB)

A secure and scalable Journal Application built using Spring Boot, implementing JWT Authentication, Spring Security, and MongoDB Atlas for cloud data storage.

🚀 Features

✨ Secure Authentication using JWT
🔐 Password Encryption using BCrypt
👤 User Registration & Login
📝 Create, Read, Update, Delete (CRUD) Journal Entries
☁️ MongoDB Atlas Cloud Database
⚡ Lombok for boilerplate reduction
🛡️ Spring Security for API protection

🛠️ Tech Stack
| Layer      | Technology      |
| ---------- | --------------- |
| Backend    | Spring Boot     |
| Security   | Spring Security |
| Auth       | JWT             |
| Encryption | BCrypt          |
| Database   | MongoDB Atlas   |
| Utilities  | Lombok          |

📁 Project Structure
journal-app/
│── src/main/java/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── config/
│   └── security/
│
│── src/main/resources/
│   ├── application.properties
│
│── pom.xml


🔄 Application Flow
🔐 Authentication Flow
[ User ]
    │
    ▼
Login / Register
    │
    ▼
Spring Security
    │
    ▼
Generate JWT Token
    │
    ▼
Send Token to Client
    │
    ▼
Client sends token in Header
    │
    ▼
Validate Token
    │
 ┌───────────────┐
 │ Valid   ❌Invalid │
 └──────┬────────┘
        ▼
   Access Granted

   
🧠 System Architecture
        ┌──────────────┐
        │   Client     │
        │ (Postman)    │
        └──────┬───────┘
               │ HTTP
               ▼
     ┌──────────────────────┐
     │ Spring Boot Backend  │
     │----------------------│
     │ Controller Layer     │
     │ Service Layer        │
     │ Repository Layer     │
     └─────────┬────────────┘
               │
               ▼
       ┌───────────────┐
       │ MongoDB Atlas │
       └───────────────┘
       
🔐 Security Flow Diagram
        Login Request
              │
              ▼
     Authenticate User
              │
              ▼
     Generate JWT Token
              │
              ▼
   Send Token to Client
              │
              ▼
Client Requests API with Token
              │
              ▼
   Validate Token (Filter)
              │
      ┌───────┴────────┐
      ▼                ▼
 Valid Token      Invalid Token
      │                │
      ▼                ▼
 Access API        Access Denied ❌
📊 Database Schema

👤 User Collection
| Field    | Type   | Description        |
| -------- | ------ | ------------------ |
| id       | String | Unique ID          |
| username | String | User name          |
| password | String | Encrypted (BCrypt) |

📝 Journal Entry Collection
| Field   | Type   | Description   |
| ------- | ------ | ------------- |
| id      | String | Entry ID      |
| title   | String | Entry title   |
| content | String | Entry content |
| date    | Date   | Created date  |
| userId  | String | Linked user   |

🔑 API Endpoints
🧑‍💻 Auth APIs
| Method | Endpoint         | Description   |
| ------ | ---------------- | ------------- |
| POST   | `/auth/create-user` | Register user |
| POST   | `/auth/login`    | Login user    |

📓 Journal APIs
| Method | Endpoint        | Description     |
| ------ | --------------- | --------------- |
| GET    | `/journal`      | Get all entries |
| POST   | `/journal`      | Create entry    |
| PUT    | `/journal/{id}` | Update entry    |
| DELETE | `/journal/{id}` | Delete entry    |

🧪 Sample Request (Login)
POST /auth/login

{
  "username": "ananta",
  "password": "123456"
}

🔐 JWT Example
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...


⚙️ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/your-username/journal-app.git
cd journal-app
2️⃣ Configure MongoDB Atlas

Add in application.properties:

spring.data.mongodb.uri=your_mongodb_connection_string
3️⃣ Run the App
mvn spring-boot:run
🧩 Dependencies (Maven)
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

🚀 Future Improvements
🔄 Refresh Token
📱 Frontend Integration
📊 Dashboard
🤖 AI Journal Suggestions

🧠 Key Concepts Used
🔐 Authentication vs Authorization
🪪 Stateless Authentication (JWT)
🔑 Password Hashing (BCrypt)
🧱 Layered Architecture (Controller → Service → Repository)
☁️ Cloud Database Integration
📌 Future Enhancements

🚀 Refresh Token Mechanism
📱 Frontend (React / Android)
📊 Analytics Dashboard
🔔 Notifications
🧠 AI-based Journal Suggestions

🙌 Contribution

Feel free to fork this repo and contribute! 💙

👩‍💻 Author

Ananta Kumari (Nova 💫)
