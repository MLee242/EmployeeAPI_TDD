package com.demoproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demoproject.ApiEmployeeTddDemoApplication;
import com.demoproject.model.Employee;

@SpringBootTest(classes=ApiEmployeeTddDemoApplication.class,
	webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class EmployeeControllerIntegrationTests {

	@LocalServerPort
	private int port;
	private final String BASE_URL = "http://localhost:";
	private final String APPLICATION_PATH = "/employees";
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private Employee employee;
	@BeforeEach
	void setUp() throws Exception {
		employee = new Employee("Moon", "Lee", "MLEE242@FORD.COM");
	}

	@Test
	@Order(1)
	void createEmployeeTest() { 
		ResponseEntity<Employee> responseEntity = this.restTemplate
				.postForEntity(BASE_URL + port + APPLICATION_PATH, 
						employee, 
						Employee.class);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		
		
	}
	@Test
	@Order(2)
	void getEmployeesTest() {
		
		ResponseEntity<List<Employee>> responseEntity = this.restTemplate
				.exchange(BASE_URL+port+APPLICATION_PATH, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Employee>>() {});
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		List<Employee> result = responseEntity.getBody();
		assertNotNull(result);
		assertTrue(result.size() == 1);
		assertEquals(employee.getFirstName(), result.get(0).getFirstName());
		assertEquals(employee.getEmail(), result.get(0).getEmail());
		
	}
	

}
