# 🚀 Social Media Backend System (Assignment Project)

## 📌 Overview
This project is a backend system developed as part of an assignment to simulate core features of a social media platform.  
It focuses on handling user interactions such as posts, likes, and comments, along with integrating Redis for real-time processing.
While not a full production-ready system, it demonstrates key backend concepts like API design, database relationships, caching, and event-based notifications.

## ⚙️ Tech Stack
- Java
- Spring Boot
- PostgreSQL (for persistent data storage)
- Redis (for real-time scoring and ranking)

---

## 🚀 Features Implemented

### 🔹 Phase 1: Core APIs
- Create users
- Create posts
- Add comments to posts
- Like posts

These APIs form the basic functionality of a social media backend.

---

### 🔹 Phase 2: Redis-based Virality Logic
- Implemented a **real-time scoring system** using Redis
- Each like/comment increases a post's score
- Used **Redis Sorted Sets** to maintain trending posts

This allows efficient ranking without heavy database queries.

---

### 🔹 Phase 3: Notification System (Basic)
- Notifications generated when:
  - A user likes a post
  - A user comments on a post
- Notifications stored in the database
- Self-notifications are avoided

This simulates user engagement tracking.

---

## 📡 APIs

### User
- `POST /api/users` → Create a user

### Posts
- `POST /api/posts` → Create a post
- `POST /api/posts/{postId}/like` → Like a post
- `POST /api/posts/{postId}/comments` → Add comment

### Redis / Ranking
- `GET /api/posts/trending` → Get trending posts
- `GET /api/posts/{postId}/score` → Get virality score

### Notifications
- `GET /api/notifications/{userId}` → Fetch notifications

## 🧪 How to Run

1. Start PostgreSQL and create the database
2. Start Redis server
3. Configure `application.properties`
4. Run the Spring Boot application
5. Use Postman to test APIs

## 💡 Key Learnings

- Designed REST APIs using Spring Boot
- Handled entity relationships using JPA/Hibernate
- Integrated Redis for real-time data processing
- Built a simple event-driven notification flow
- Understood separation of concerns (Controller → Service → Repository)

## ⚠️ Limitations

- No authentication/authorization
- Notifications are stored in DB (not real-time push)
- No frontend integration
- Basic validation and error handling

## 🚀 Future Improvements

- Add JWT-based authentication
- Implement real-time notifications (WebSockets)
- Add pagination and filtering
- Improve validation and exception handling
- Dockerize the application

## 📂 Additional

- Postman collection included for API testing
- Designed as a learning-focused backend project

