# Govtech Assignment

## Setup
1.) git clone https://github.com/ronchuaml/govtech_assignment.git<br>
2.) cd govtech_assignment <br>
3.) mvn clean install - install dependencies<br>
4.) mvn spring-boot:run - to run project<br>

## Additional Info
Api documentation => http://localhost:8080/swagger-ui/index.html<br>
Seeded with schema.sql and data.sql, using H2 in memory MySQL database, seeded with admin account<br>

## For Api Testing use postman
1.) send 
{
    "username": "admin",
    "password": "admin"
}
to http://localhost:8080/authenticate<br>
2.) Copy the jwtToken<br>
3.) For all api calls using postman, add Key: Authorization and Value: Bearer <jwtToken value>

## Endpoints

POST<br>
/authenticate<br>
<br>
GET<br>
/api/applications<br>
<br>
POST<br>
/api/applications<br>
<br>
GET<br>
/api/applicants<br>
<br>
POST<br>
/api/applicants<br>
<br>
GET<br>
/api/schemes<br>
<br>
GET<br>
/api/schemes/eligible<br>
