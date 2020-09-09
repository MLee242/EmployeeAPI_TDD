# Employee API using TDD
## Employee RESTful Webrvice built using Spring Boot with TDD deployed through Heroku

Using **Code Mocks(Mockito Framework), JUnit 5 Testing, Integration test**

**Base URL**: `https://employeeapitdd.herokuapp.com/`

Request | Description
------------ | -------------
**GET** `/employee`  | Gets All Employees in the embedded H2 database url: <br> jdbc:h2:mem:testdb
**POST** `/employee` <br> *Requestbody (JSON/XML):* <br> • `String firstName` required <br> • `String lastName` required <br> • `String email` required | Add employee to H2 database

