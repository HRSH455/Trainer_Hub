# TrainerHub API Documentation

## Overview

TrainerHub is a full-stack training management system with role-based access control. This API documentation covers all endpoints for the Spring Boot backend.

**Base URL:** `https://trainer-hub-ekas.onrender.com/api`


## Authentication Endpoints

### POST /api/auth/signup
Register a new user.

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "password123",
  "role": "MANAGER" // or "COORDINATOR" or "TRAINER"
}
```

**Response:**
```json
{
  "success": true,
  "message": "User registered successfully",
  "data": {
    "id": 1,
    "email": "user@example.com",
    "role": "MANAGER"
  }
}
```

### POST /api/auth/login
Authenticate and get JWT token.

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Login successful",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "user": {
      "id": 1,
      "email": "user@example.com",
      "role": "MANAGER"
    }
  }
}
```

### POST /api/auth/forgot-password
Request OTP for password reset.

**Request Body:**
```json
{
  "email": "user@example.com"
}
```

**Response:**
```json
{
  "success": true,
  "message": "OTP sent to email"
}
```

### POST /api/auth/reset-password
Reset password using OTP.

**Request Body:**
```json
{
  "email": "user@example.com",
  "otp": "123456",
  "newPassword": "newpassword123"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Password reset successful"
}
```

## Trainer Endpoints

### GET /api/trainers
Get all trainers (Coordinator only).

**Authorization:** Bearer token (Coordinator role)

**Response:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "name": "John Doe",
      "email": "john@example.com",
      "skills": ["Java", "Spring"],
      "experience": 5
    }
  ]
}
```

### POST /api/trainers
Create a new trainer (Coordinator only).

**Authorization:** Bearer token (Coordinator role)

**Request Body:**
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "skills": ["Angular", "TypeScript"],
  "experience": 3
}
```

### GET /api/trainers/{id}
Get trainer details.

**Authorization:** Bearer token

### PUT /api/trainers/{id}
Update trainer (Coordinator only).

**Authorization:** Bearer token (Coordinator role)

### DELETE /api/trainers/{id}
Delete trainer (Coordinator only).

**Authorization:** Bearer token (Coordinator role)

## Requirement Endpoints

### GET /api/requirements
Get all requirements.

**Authorization:** Bearer token

**Response:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "title": "Java Training",
      "description": "Advanced Java course",
      "skillsRequired": ["Java", "Spring"],
      "postedBy": "Manager Name"
    }
  ]
}
```

### POST /api/requirements
Create a new requirement (Manager only).

**Authorization:** Bearer token (Manager role)

**Request Body:**
```json
{
  "title": "Angular Training",
  "description": "Frontend development training",
  "skillsRequired": ["Angular", "TypeScript"]
}
```

### GET /api/requirements/{id}
Get requirement details.

**Authorization:** Bearer token

### PUT /api/requirements/{id}
Update requirement (Manager only).

**Authorization:** Bearer token (Manager role)

### DELETE /api/requirements/{id}
Delete requirement (Manager only).

**Authorization:** Bearer token (Manager role)

## Feedback Endpoints

### GET /api/feedback
Get all feedback.

**Authorization:** Bearer token

### POST /api/feedback
Create feedback (Manager only).

**Authorization:** Bearer token (Manager role)

**Request Body:**
```json
{
  "trainerId": 1,
  "rating": 5,
  "comments": "Excellent performance"
}
```

### GET /api/feedback/{id}
Get feedback details.

**Authorization:** Bearer token

### PUT /api/feedback/{id}
Update feedback (Manager only).

**Authorization:** Bearer token (Manager role)

### DELETE /api/feedback/{id}
Delete feedback (Manager only).

**Authorization:** Bearer token (Manager role)

## Email Endpoint

### POST /api/email/send
Send email (Admin/Coordinator only).

**Authorization:** Bearer token

**Request Body:**
```json
{
  "to": "recipient@example.com",
  "subject": "Subject",
  "body": "Message body"
}
```

## Flow 

1. **Signup:** User registers with email, password, and role.
2. **Login:** User logs in to receive JWT token.
3. **Post Requirement (Manager):** Manager creates a training requirement.
4. **View Trainers (Coordinator):** Coordinator views available trainers.
5. **Assign Trainer (Coordinator):** Coordinator assigns a trainer to the requirement.
6. **Post Feedback (Manager):** Manager provides feedback on the assigned trainer.
7. **View Feedback (Trainer):** Trainer views their feedback.

