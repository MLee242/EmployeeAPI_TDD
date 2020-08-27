package com.demoproject.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demoproject.model.Employee;
import com.demoproject.service.EmployeeService;


//Unit Testing
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	
	@Mock
	EmployeeService employeeService;
	
	@InjectMocks
	EmployeeController employeeController;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	
	@Test
	void addEmployeeTest() {
		
		Employee employee = new Employee("Moon", "Lee", "MLEE242@ford.com");
		
		when(employeeService.createEmployee(any(Employee.class))).thenReturn(employee);
		
		
		ResponseEntity<Employee> responseEntity = employeeController.addEmployee(employee);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		
		
		
	}
	
	
	@Test
	@Disabled
	void getEmployeesTest() {
		
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee("Moon", "Lee", "MLEE242@ford.com");
		Employee employee2 = new Employee("Lebron", "James", "LJAMES@ford.com");
		employees.add(employee1);
		employees.add(employee2);
		
		when(employeeService.getAllEmployees()).thenReturn(employees);
		ResponseEntity<List<Employee>> responseEntity = employeeController.getAllEmployees();
		
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		List<Employee> result = responseEntity.getBody();
		assertNotNull(result);
		assertEquals(employees.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(employees.get(1).getEmail(), result.get(1).getEmail());
		
	}

}
