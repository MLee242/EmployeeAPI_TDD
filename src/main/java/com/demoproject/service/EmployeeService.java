package com.demoproject.service;

import java.util.List;

import com.demoproject.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee createEmployee(Employee employee);
}
