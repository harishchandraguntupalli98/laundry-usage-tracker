Laundry Usage Tracker

A simple full-stack web application that helps people living in a shared house track washer and dryer usage in real time — no confusion, no unnecessary trips to the basement.

🚀 Live App:
👉 https://laundry-usage-tracker.netlify.app/

📌 Problem Statement

In a shared house with multiple roommates and a single washer and dryer, it’s often unclear:

Who is currently using the machine

Whether the washer or dryer is free

If it’s worth going downstairs to check

This application solves that problem by providing a shared, real-time view of washer and dryer usage that everyone can access from their phone or laptop.

✅ Features

View current status of washer and dryer

See who is using a machine

Mark a machine as “In Use”

Release a machine when done

Shared state visible to all users

No login required (simple and fast)

Works from anywhere (cloud deployed)

🏗️ Tech Stack
Backend

Java 17

Spring Boot

REST APIs

Docker

Maven

Frontend

HTML

CSS

Vanilla JavaScript

Deployment

Backend: Render (Dockerized Spring Boot app)

Frontend: Netlify (Static site hosting)

🌍 Architecture Overview
Browser (Netlify)
     |
     |  HTTPS REST Calls
     |
Spring Boot API (Render, Docker)


Frontend makes REST calls to backend

Backend maintains washer/dryer state in memory

Backend exposes APIs consumed by frontend

🔗 Live URLs

Frontend:
https://laundry-usage-tracker.netlify.app/

Backend API Base:
https://laundry-usage-tracker.onrender.com/api

🔌 API Endpoints
Get current machine status
GET /api/status


Response

[
  { "machine": "WASHER", "inUse": false, "usedBy": null },
  { "machine": "DRYER", "inUse": true, "usedBy": "Harish" }
]

Use a machine
POST /api/use


Request Body

{
  "machine": "WASHER",
  "name": "Harish"
}

Release a machine
POST /api/release


Request Body

{
  "machine": "WASHER"
}

🖥️ Running Locally (Optional)
Backend
cd backend
./mvnw spring-boot:run


Backend runs at:

http://localhost:8080

Frontend
cd frontend
python3 -m http.server 5500


Open:

http://localhost:5500

⚠️ Known Limitations

Application state is stored in memory

If the backend restarts, washer/dryer status resets

No authentication (by design for simplicity)

These are acceptable tradeoffs for a lightweight shared-house utility.

🚀 Future Enhancements

Persist state using a database (PostgreSQL)

Auto-release machines after a time limit

Usage history/logs

Simple authentication (PIN or username lock)

UI improvements for mobile devices

📄 License

This project is for educational and personal use.

👤 Author

Harish Chandra Guntupalli
Java Full Stack Developer (Learning Project)
