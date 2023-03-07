package com.te.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.mongodb.entity.Employee;
import com.te.mongodb.response.SuccessResponse;
import com.te.mongodb.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<SuccessResponse> registerEmployee(@RequestBody Employee employee) {
		Employee registerEmployee = service.registerEmployee(employee);
		if (registerEmployee != null) {

			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).data(registerEmployee).msg("Register successfully").build(),
					HttpStatus.OK);

		}

		else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().error(true).data(registerEmployee)
					.msg("Register not successfull").build(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<SuccessResponse> getAllEmployee() {
		List<Employee> allEmployee = service.getAllEmployee();
		if (!allEmployee.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().error(false).list(allEmployee).build(),
					HttpStatus.OK);
		}

		else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().error(true).list(allEmployee).build(),
					HttpStatus.OK);
		}
	}

	
	@GetMapping("/delete")
	public ResponseEntity<SuccessResponse> deleteEmployee(Integer id) {
		 Boolean deleteEmployee = service.deleteEmployee(id);
		if (deleteEmployee) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).msg("Employee removed").build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().error(true)
					.msg("ID not found").build(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee = service.updateEmployee(employee);
		if (updateEmployee!=null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(false).msg("Employee updated").data(updateEmployee).build(),
					HttpStatus.OK);
		}
		else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().error(true).msg("Employee not updated").data(updateEmployee).build(),
					HttpStatus.OK);
		}
	}

}
