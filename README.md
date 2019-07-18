# Spring challenge
A simple Spring Boot application that demonstrates the basics of an API.

## Application URL
*Please note that the provided link **does not lead** to any user-friendly site since the application is intended to be consumed by other applications and not directly by humans.*

[https://spring-challenge.herokuapp.com/](https://spring-challenge.herokuapp.com/)

## API documentation URL

For further documentation regarding the use of this application please refer to [https://spring-challenge.herokuapp.com/swagger-ui.html](https://spring-challenge.herokuapp.com/swagger-ui.html)

## Purpose
This application uses an in-memory database (H2) to save some `Customer`'s basic information. 

Such information can be then used to perform some calculations and retrieve certain KPIs.

Made with API calls in mind, the application does not offer much user-friendly information besides its documentation.

## Provided operations
- Customer creation
- KPIs calculation
- Full customer listing

## Technology stack
- Microservices framework: [Spring Boot](https://spring.io/projects/spring-boot)
- API documentation: [Swagger 2](https://swagger.io/)
- In-memory database: [H2](https://www.h2database.com/html/main.html)
- Cloud application platform: [Heroku](https://dashboard.heroku.com)
- Endpoint testing: [Postman](https://www.getpostman.com)
