# User Profile Microservice

## Purpose
A small demonstration headless microservice implementing a RESTful API. It allows the user to create a user profile and one or more attendant appointments.

## Prerequisites
- Java 8
- Docker

For a full list of dependencies, see pom.xml

## Running the application
`docker-compose up --build`

## Test in Postman:
Start the service in Docker and use a request such as the below to make a post request to http://localhost:8080/api/v1/users.
```javascript
{
  "email": "example@test.com",
  "firstName": "Testy",
  "lastName": "McTestface",
  "appointments": [
    {"roleId": 1234, 
    "roleDescription": "Dev", 
    "organisationName": "Devs4u"}
    ]
}
```

The application uses a PostgreSQL database which runs in Docker and automatically applies database migrations using flyway. 

### To explore the database in conjunction with Postman:
`docker exec -it postgres bash`

Then:
`psql -U postgres`

Then connect to **projectdb**.

