# CS CAR SERVICE APP
This example project demonstrates  fleet management using Spring Boot web application

# Pre-requisites
1. Java 1.8 installed
2. Maven version >=3.3.3
3. Spring  : https://start.spring.io/  
4. Eclipse IDE  

# Requirement :
	Need to build Rest Api for fleet management

# Build : spring-boot-cs-app application 
```java
	Download project from git repo from the following location and extract project
	   https://github.com/satya-moganti/spring-boot-cs-app.git
	Build a jar using following command
	   mvn clean install
	Run application using following command
       cd target
	   java -jar spring-boot-cs-app.jar	

```	

# Implementation :
  The CS Car Service App Implemented using following technologies
    1. Spring boot  for developing application
	2. Maven for dependency managemnt
	3. Swagger for Api Documentation
	4. Junit for Unit test case
	5. Logger for logging information
	6. H2 Database for in memory db managemnt

## H2 Database  
```java
	Access H2 Database using below URL 
	
	http://127.0.0.1:8080/h2-console 
	JDBC URL : jdbc:h2:mem:fleetdb
	Username : admin
	Password : admin
	
```

## Swagger API 
```java
	Access Swagger docuemntation using below URL, will provide usecases of Rest Api (validate and execute api here)  
	  http://localhost:8080/swagger-ui/
	 
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.10/maven-plugin/reference/html/)
* [Spring Boot Documentation] (https://docs.spring.io/spring-boot/docs/2.6.10/reference/htmlsingle/#documentation)
* [Validation](https://docs.spring.io/spring-boot/docs/2.6.10/reference/htmlsingle/#io.validation)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

