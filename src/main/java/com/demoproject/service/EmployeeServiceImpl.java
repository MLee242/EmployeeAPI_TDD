package com.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.model.Employee;
import com.demoproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		
		
		return employees;
	}
	
	@Override 
	public Employee createEmployee(Employee employee) {
		Employee result = employeeRepository.save(employee);
		return result;
	}

}
