package com.demoproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.model.Employee;
import com.demoproject.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> result = employeeService.getAllEmployees();
		if(result.size() > 0) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(produces= {
			MediaType.APPLICATION_JSON_VALUE	
	},consumes = {
			MediaType.APPLICATION_JSON_VALUE
			
	})
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		
		Employee result = employeeService.createEmployee(employee);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	
}
