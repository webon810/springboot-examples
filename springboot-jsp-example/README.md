# springboot-example
springboot-jsp-example

## What you'll need
JDK 8+ or OpenJDK 8+
Maven 3+

## Define Controller and View Template

Home Controller - HomeController.java

Controller maps HTTP Requests with View.

## @RequestMapping maps (/ or /homeIndex or /helloWorld) request to helloHome() method.

name is a query string parameter of /homeIndex request.

Model object passes value to hello view (hello.jsp).

View Template - helloHome.jsp

## Run with Maven - localhost:8080

```
$ mvn clean spring-boot:run
```
