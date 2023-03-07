package com.te.beanvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.beanvalidation.entity.Employee;
import com.te.beanvalidation.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> registerEmployee(@Valid @RequestBody Employee employee){
		
		Employee registerEmployee = service.registerEmployee(employee);
		
			return new ResponseEntity<String>("Employee Registered",HttpStatus.OK);
		
		
		
	}

}
