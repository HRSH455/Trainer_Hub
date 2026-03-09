# Trainer Hub

A full-stack training management system with role-based access for managers, coordinators, and trainers. Manage training requirements, assign trainers, and collect feedback.

## Features

- Role-based authentication (Manager, Coordinator, Trainer)
- Trainer and training requirement management
- Feedback system
- Password reset via email
- Search, filter, and pagination
- Responsive UI with Angular Material

## Tech Stack

**Frontend**: Angular 16, TypeScript, Angular Material, Bootstrap, RxJS
**Backend**: Spring Boot 3.5.4 (Java 21), Spring Security, JWT, Spring Data JPA, MySQL

## Project Structure

```
Trainer_Hub-main/
├── angularapp/              # Angular frontend application
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/          # UI components for different roles and features
│   │   │   │   ├── login/           # User authentication
│   │   │   │   ├── home-page/       # Home page
│   │   │   │   ├── navbar/          # Navigation component
│   │   │   │   ├── manager-*/       # Manager-related components



## Project Structure

```
Trainer_Hub-main/
├── angularapp/
│   ├── src/app/
│   │   ├── components/          # UI components (login, home, manager, coordinator, trainer views)
│   │   ├── guards/              # Auth guards
│   │   ├── interceptors/        # HTTP interceptors
│   │   ├── models/              # Data models
│   │   ├── services/            # API services
│   │   ├── pipes/               # Filter and search pipes
│   │   ├── pagination/          # Custom pagination
│   │   ├── custom-snackBar/     # Dialog components
│   │   ├── app-routing.module.ts
│   │   └── app.module.ts
│   └── package.json
│
└── springapp/
    ├── src/main/java/com/examly/springapp/
    │   ├── controller/          # AuthController, TrainerController, RequirementController, FeedbackController, EmailController
    │   ├── service/             # Business logic
    │   ├── model/               # Entity classes
    │   ├── repository/          # JPA repositories
    │   ├── config/              # Security config
    │   ├── exceptions/          # Custom exceptions
    │   └── SpringappApplication.java
    ├── src/main/resources/
    │   ├── application.properties
    │   └── logback-spring.xml
    └── pom.xml
```

```bash
cd angularapp
```


2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```
The frontend will be available at `http://localhost:8081`

4. Build for production:
```bash
npm build
```

### Backend Setup (Spring Boot)

1. Navigate to the Spring app directory:
```bash
cd springapp
```

2. Configure the database in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/trainer_hub
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Run the application using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or build a JAR and run it:
```bash
./mvnw clean package
java -jar target/springapp-0.0.1-SNAPSHOT.jar
```

The backend API will be available at `http://localhost:8080`

## Available Scripts

## Setup

### Prerequisites
- Node.js & npm
- Java 21
- MySQL Server

### Frontend
```bash
cd angularapp
npm install
npm start  # Runs on http://localhost:8081
```

### Backend
```bash
cd springapp
# Update database config in src/main/resources/application.properties
./mvnw spring-boot:run  # Runs on http://localhost:8080
```
### Trainer
- View available training requirements
- Accept or decline assignments
- Receive and view feedback
- Manage profile information

## Key Features Explained

### Authentication & Security
- JWT-based token authentication
- HTTP interceptors for automatic token attachment to requests
- Auth guards to protect routes based on user roles
- Password encryption and secure password reset flow

### Real-time Feedback
- Managers and coordinators can provide feedback on trainers
- Custom snackbar dialogs for confirmations and actions
- Material Design dialog components for better UX

### Data Management
- Custom pagination service for efficient data browsing
- Multiple filter pipes: by status, category, name, expertise, department
- Search functionality across different data types

### Responsive Design
- Bootstrap 5 for responsive layouts
- Angular Material for consistent UI components
- Custom animations for smooth transitions
- FontAwesome icons for visual clarity

## Testing

### Frontend Tests
```bash
cd angularapp
npm test
```

### Backend Tests
## Available Commands

**Frontend**: `npm start`, `npm build`, `npm test`, `npm run watch`
**Backend**: `./mvnw spring-boot:run`, `./mvnw clean package`, `./mvnw test` model
- `paginatedTrainers.model.ts` - Paginated trainer response
- `paginatedRequirements.model.ts` - Paginated requirement response
- `paginatedFeedbacks.model.ts` - Paginated feedback response

### Frontend Services
- `auth.service.ts` - Authentication and user management
- API services for trainers, requirements, and feedback
- Email service for password reset communications

## API Endpoints

| Endpoint | Method | Purpose |
|----------|--------|---------|
| `/api/auth/login` | POST | Login |
| `/api/auth/signup` | POST | Register |
| `/api/auth/forgot-password` | POST | Password reset request |
| `/api/trainers` | GET, POST | List/create trainers |
| `/api/trainers/{id}` | GET, PUT, DELETE | Trainer details |
| `/api/requirements` | GET, POST | List/create requirements |
| `/api/requirements/{id}` | GET, PUT, DELETE | Requirement details |
| `/api/feedback` | GET, POST | List/create feedback |
| `/api/feedback/{id}` | GET, PUT, DELETE | Feedback details |
| `/api/email/send` | POST | Send email |
2. **Port Already in Use**
   - Change the port in `package.json` (frontend) or `application.properties` (backend)

3. **CORS Errors**
   - Ensure backend CORS is properly configured
   - Check that frontend URL is whitelisted

4. **Authentication Issues**
   - Clear browser local storage
   - Verify JWT token configuration

## Contributing

Guidelines for contributing to the project:
1. Create a feature branch
2. Make your changes
3. Write/update tests
4. Submit a pull request
## User Roles

| Role | Permissions |
|------|-------------|
| **Manager** | Post requirements, provide feedback, view trainers |
| **Coordinator** | Manage trainers, view requirements, assign trainers, view feedback |
| **Trainer** | View requirements, receive feedback, manage profile |

## Testing

```bash
# Frontend
cd angularapp && npm test

# Backend
cd springapp && ./mvnw test
```

## Deployment

**Frontend**: Build with `npm run build` and deploy `dist/` folder to any static hosting
**Backend**: Build with `./mvnw clean package` and run the JAR on your server

## Troubleshooting

- **Database Connection Error**: Ensure MySQL is running and credentials are correct in `application.properties`
- **Port Already in Use**: Change port in `package.json` (frontend) or `application.properties` (backend)
- **CORS Errors**: Verify backend CORS configuration
- **Authentication Issues**: Clear browser local storage and verify JWT token config

