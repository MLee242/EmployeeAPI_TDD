# Employe API using TDD
## Employe RESTful Webservice built using Spring Boot with TDD

Using **Code Mocks(Mockito Framework), JUnit 5 Testing, Integration test**

Request | Description
------------ | -------------
**GET** `/employee`  | Gets All Employees in the embeeded H2 database url: <br> jdbc:h2:mem:testdb
**POST** `/employee` <br> *Requestbody:* <br> • `String firstname` required <br> • `String lastname` required <br> • `String email` required | Add employee to H2 database

