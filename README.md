#Govtech Assignment

## Setup
1.) git clone https://github.com/ronchuaml/govtech_assignment.git
2.) cd govtech_assignment 
3.) mvn clean install - install dependencies
4.) mvn spring-boot:run - to run project

## Additional Info
Api documentation => http://localhost:8080/swagger-ui/index.html
Seeded with schema.sql and data.sql, using H2 in memory MySQL database, seeded with admin account

## For Api Testing use postman
1.) send 
{
    "username": "admin",
    "password": "admin"
}
to http://localhost:8080/authenticate
2.) Copy the jwtToken
3.) For all api calls using postman, add Key: Authorization and Value: Bearer <jwtToken value>

## Endpoints

POST
/authenticate

GET
/api/applications

POST
/api/applications

GET
/api/applicants

POST
/api/applicants

GET
/api/schemes

GET
/api/schemes/eligible