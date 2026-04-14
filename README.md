📓 Journal App
🚀 Spring Boot • JWT • MongoDB • Secure REST APIs










✨ Overview

A secure and scalable Journal Application built with Spring Boot, implementing:

🔐 JWT Authentication
🛡️ Spring Security
🔑 BCrypt Encryption
☁️ MongoDB Atlas

This project demonstrates real-world backend architecture with authentication, authorization, and CRUD operations.

🚀 Features
🔐 Secure Login & Registration (JWT)
🔑 Password Encryption using BCrypt
📝 Journal CRUD Operations
☁️ MongoDB Atlas Cloud Storage
⚡ Clean Architecture (Controller → Service → Repository)
🛡️ Protected APIs using Spring Security
🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot
Security	Spring Security
Auth	JWT
Encryption	BCrypt
Database	MongoDB Atlas
Tools	Lombok, Maven
🧠 System Architecture
flowchart LR
    A[🌐 Client / Postman] -->|HTTP Request| B[🚀 Spring Boot Backend]

    subgraph Backend Layers
        B --> C[📥 Controller]
        C --> D[⚙️ Service]
        D --> E[🗄️ Repository]
    end

    E --> F[(☁️ MongoDB Atlas)]
🔐 Authentication Flow
flowchart TD
    A[👤 User] --> B[Login / Register]
    B --> C[Spring Security]
    C --> D[Generate JWT Token]
    D --> E[Send Token to Client]
    E --> F[Client sends Token in Header]
    F --> G[Validate Token]

    G -->|✅ Valid| H[Access Granted]
    G -->|❌ Invalid| I[Access Denied]
🔐 Security Flow (JWT Filter)
flowchart TD
    A[Login Request] --> B[Authenticate User]
    B --> C[Generate JWT Token]
    C --> D[Send Token]

    D --> E[Client Request with Token]
    E --> F[JWT Filter]
    F --> G[Validate Token]

    G -->|Valid| H[Allow API Access]
    G -->|Invalid| I[Block Request]
🔄 Request Lifecycle
sequenceDiagram
    participant User
    participant Client
    participant Controller
    participant Service
    participant Repository
    participant DB

    User->>Client: Request
    Client->>Controller: HTTP Request
    Controller->>Service: Process
    Service->>Repository: DB Call
    Repository->>DB: Query
    DB-->>Repository: Data
    Repository-->>Service: Data
    Service-->>Controller: Response
    Controller-->>Client: JSON
    Client-->>User: Output
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
📊 Database Schema
👤 User Collection
Field	Type	Description
id	String	Unique ID
username	String	User name
password	String	Encrypted password
📝 Journal Entry Collection
Field	Type	Description
id	String	Entry ID
title	String	Entry title
content	String	Entry content
date	Date	Created date
userId	String	Linked user
🔑 API Endpoints
🔐 Auth APIs
Method	Endpoint	Description
POST	/auth/register	Register user
POST	/auth/login	Login user
📓 Journal APIs
Method	Endpoint	Description
GET	/journal	Get all entries
POST	/journal	Create entry
PUT	/journal/{id}	Update entry
DELETE	/journal/{id}	Delete entry
🧪 Sample Request
POST /auth/login

{
  "username": "ananta",
  "password": "123456"
}
🔐 JWT Example
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
⚙️ Setup Instructions
1️⃣ Clone Repository
git clone https://github.com/your-username/journal-app.git
cd journal-app
2️⃣ Configure MongoDB
spring.data.mongodb.uri=your_mongodb_connection_string
3️⃣ Run Application
mvn spring-boot:run
📦 Dependencies
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
🚀 Future Enhancements
🔄 Refresh Token Mechanism
📱 Frontend (React / Android)
📊 Dashboard & Analytics
🔔 Notifications
🤖 AI-based Journal Suggestions
🙌 Contribution

Contributions are welcome!
Fork the repo and submit a PR 💙

👩‍💻 Author

Ananta Kumari (Nova 💫)

⭐ If you like this project, give it a star!
