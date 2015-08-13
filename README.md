<h1> IBM Bluemix - Spring Boot / Spring Data JPA / Thymeleaf demo </h1>

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

<h2> Deploy to IBM Bluemix </h2>

- When deploying to IBM Bluemix you must bind the app to a MYSQL service as shown in the manifest.yml below.

```
applications:
- name: pas-albums
  memory: 512M
  instances: 1
  host: pas-albums
  domain: mybluemix.net
  path: ./target/BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
  buildpack: java_buildpack
  services:
    - pas-mysql
```

Note: The manifest file below assumes you have a MYSQL service named "pas-mysql"

- Example of deployment

```

```

IBM Bluemix Dashboard of application once pushed

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-console-albums.png)
