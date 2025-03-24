# QAP2-Semester4

# Golf Club Management System

This is a Spring Boot REST API Application for QAP 2 for managing a golf club's members and tournaments.

## Technologies Used

- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven
- 
## API Endpoints

### Member Endpoints

- `GET /api/members/allMembers` - Get all members
- `POST /api/members` - Add a new member
- `GET /api/members/search/name/{name}` - Find members by name
- `GET /api/members/search/phone/{phoneNum}` - Find members by phone number
- `GET /api/members/search/start-date?startDate=YYYY-MM-DD` - Find members by membership start date
- `GET /api/members/search/tournament-start-date/{tournamentStartDate}` - Find members by tournament start date

### Tournament Endpoints

- `GET /api/tournaments` - Get all tournaments
- `POST /api/tournaments` - Add a new tournament
- `GET /api/tournaments/search/start-date?startDate=YYYY-MM-DD` - Find tournaments by start date
- `GET /api/tournaments/search/location/{location}` - Find tournaments by location
- `GET /api/tournaments/{tournamentId}/members` - Get all members in a tournament
- `POST /api/tournaments/{tournamentId}/members/{memberId}` - Add a member to a tournament


### Prerequisites

Ensure you have Docker, Docker Compose anf git installed on your machine.

### Setup Instructions

1. Clone the repository:
   ```
   https://github.com/victoriaa-b/QAP2-Semester4/edit/main/README.md
   ```

2. Build and run the Docker containers:
   ```
   docker-compose up -d
   ```

   This will:
   - Start a PostgreSQL database container on 3306
   - Build and run the Spring Boot application
   - Expose the API on port 8080

3. The API will be available at `http://localhost:8080`

4. To stop the containers:
   ```
   docker-compose down
   ```

## Testing on Postman

Examples of an API call:

### Create a new member
POST http://localhost:8080/api/members
```json
{
  "name": "Victoria penney",
  "email": "victoria.penney@example.com",
  "phoneNum": "222-123-4522",
  "address": "22 Coffee Ave",
  "membershipStartDate": "2022-02-02",
  "membershipLength": 4
}
```

