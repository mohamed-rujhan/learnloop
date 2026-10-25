# LearnLoop – Online Learning Platform (Backend)

REST API for **LearnLoop**, an online learning platform where instructors publish courses, lessons and videos and
students enrol, pay and leave reviews. Built with **Spring Boot**, **MongoDB** and **Firebase Storage**, with
**JWT-based authentication**. Designed to be used by a React (Vite) frontend.

> Team project built together with [@Pirashanth003](https://github.com/Pirashanth003).

## Features

- **Authentication** – login with JWT; Spring Security filter protects the API.
- **Courses & lessons** – full CRUD for courses and their lessons.
- **Students & instructors** – profile management and instructor administration.
- **Enrolments, payments & reviews** – students enrol in courses, payments are recorded, courses can be reviewed.
- **Video uploads** – course videos and cover images are uploaded to Firebase Storage; metadata is stored in MongoDB.
- **Contact form** – messages from the website are emailed via Gmail SMTP.

## Tech stack

| Layer | Technology |
|---|---|
| Language / framework | Java 17, Spring Boot 3.4 (Web, Security, Data MongoDB, Mail) |
| Auth | JWT (jjwt), Spring Security |
| Database | MongoDB (Atlas) |
| File storage | Firebase / Google Cloud Storage |
| API docs | springdoc OpenAPI / Swagger UI |
| Build | Maven (wrapper included) |

## Project structure

```
src/main/java/com/example/LearnLoop/
├── config/       # Security, CORS, Firebase configuration
├── controller/   # REST controllers
├── model/        # MongoDB documents and request models
├── repository/   # Spring Data MongoDB repositories
├── security/     # JWT utilities, auth filter, user details
└── service/      # Business logic (interfaces + Impl/)
```

## Main endpoints

| Method | Path | Purpose |
|---|---|---|
| POST | `/api/auth/login` | Log in and receive a JWT |
| GET / POST | `/api/courses` | List / create courses |
| GET / PUT / DELETE | `/api/courses/{courseId}` | Read / update / delete a course |
| GET / POST | `/api/lesson` | List / create lessons |
| GET / POST | `/api/students` | List / register students |
| GET / POST | `/api/payment` | List / record payments |
| GET | `/api/videos` | List videos |
| POST | `/api/videos/upload` | Upload a video and cover image |
| POST | `/api/contact/send` | Send a contact-form message |

## Running locally

**Requirements:** Java 17, a MongoDB database, a Firebase project with Storage enabled, and a Gmail
[app password](https://support.google.com/accounts/answer/185833) for sending mail.

1. Copy `.env.example` and fill in your own values. Secrets are read from environment variables and are
   **never committed**:

   | Variable | Description |
   |---|---|
   | `MONGODB_URI` | MongoDB connection string |
   | `MAIL_USERNAME` / `MAIL_PASSWORD` | Gmail address and app password used to send mail |
   | `CONTACT_EMAIL` | Address that receives contact-form messages |
   | `FIREBASE_CREDENTIALS_PATH` | Path to your Firebase service-account JSON (keep it outside the repo) |
   | `FIREBASE_BUCKET` | Firebase Storage bucket, e.g. `your-project.appspot.com` |

2. Export the variables and start the app:

   ```bash
   set -a; source .env; set +a
   ./mvnw spring-boot:run
   ```

The API runs on `http://localhost:8080`, with interactive API docs (springdoc OpenAPI) at
`http://localhost:8080/swagger-ui.html`. CORS is configured for a frontend on `http://localhost:5173`.
