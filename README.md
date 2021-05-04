# Questions Room

This little app creates an endpoint available at `localhost/room/{roomName}`. 
If room doesn't exist it will be created. 
If it exists you will join it. People inside of the room can post 
questions that are displayed for everyone in that room.

### To run:
`mvn spring-boot:run`


### To package:
`mvnw package`

### Tech Stack:
- Java 11
- SpringBoot 2.4.5
- H2 Database
- Thymeleaf
- Bootstrap 5
