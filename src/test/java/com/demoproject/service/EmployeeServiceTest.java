package com.demoproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demoproject.model.Employee;
import com.demoproject.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	@Test
	void createEmployee() {
		Employee employee = new Employee("Moon", "Lee", "MLEE242@ford.com");
		
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		
		Employee result = employeeServiceImpl.createEmployee(employee);
		assertNotNull(result);
		assertEquals(result.getFirstName(), employee.getFirstName());
		assertEquals(result.getLastName(), employee.getLastName());
		assertEquals(result.getEmail(), employee.getEmail());
		
	}

	@Disabled
	@Test
	void testGetAllEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee("Moon", "Lee", "MLEE242@ford.com");
		Employee employee2 = new Employee("Lebron", "James", "LJAMES@ford.com");
		employees.add(employee1);
		employees.add(employee2);
		
		when(employeeRepository.findAll()).thenReturn(employees);
		

		List<Employee> result = employeeServiceImpl.getAllEmployees();
		assertNotNull(result);
		assertEquals(employees.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(employees.get(1).getEmail(), result.get(1).getEmail());
		
	}

}
