#Questions Room

This little app created an endpoint available at `localhost/room/{roomName}`. 
If room doesn't exists it will be created. 
If it exists you will join it. People inside of the room can post 
questions that are displayed for everyone in that room.

###To run:
`mvn spring-boot:run`

###Tech Stack:
- Java 11
- SpringBoot 2.4.5
- H2 Database
- Thymeleaf
- Bootstrap 5