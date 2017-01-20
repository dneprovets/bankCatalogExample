Demo bank catalog project

Technologies:

 - Java 8 
 - Spring Boot 
 - Hateoas
 - MongoDB
 - gradle

Perquisites:

 - Java 8
 - MongoDB without password with default port
 - free 8080 port
 
Build app:

    gradle build

Run:

    java -jar build/libs/bankCatalogExample-0.1.0.jar


Static path:

    src/main/resources/static [put your frontend here]

Import test mongo database:

    mongorestore --db test src/main/resources/test
    
Must read:
    
    https://spring.io/understanding/HATEOAS



