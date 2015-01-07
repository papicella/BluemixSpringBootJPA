<h1> Apples Cloud Foundry Spring Boot / Spring Data JPA / Thymeleaf demo </h1>

The following demo shows how to bind to a MYSQL service from a data bound Spring Boot [Spring Data JPA]. 
This ensures you don't have to write any code to retrieve the bound data source connection details as 
spring auto configures this for you using spring cloud service connector library.

![alt tag](https://dl.dropboxusercontent.com/u/15829935/albums-view-bluemix.png)

<h2> Steps to run locally </h2>

- Clone code as follows

```
> git clone https://github.com/papicella/BluemixSpringBootJPA.git
```

- package as shown below

```
> mvn package
```

- cd target
- Run demo prior to deploying to Cloud Foundry as follows

```
> java -jar ApplesCFDemo-0.0.1-SNAPSHOT.jar
```

- Access as follows in a browser

```
http://localhost:8080/
```

<h2> Deploy to IBM Bluemix <h2>