package com.te.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.springsecurity.dto.AuthenticateRequest;
import com.te.springsecurity.dto.AuthenticateResponse;
import com.te.springsecurity.entity.Employee;
import com.te.springsecurity.jwtutil.EmployeeJWTUtil;
import com.te.springsecurity.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EmployeeController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private EmployeeJWTUtil jwtUtil;	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeJWTUtil employeeJWTUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticateResponse> getAuthenticate(@RequestBody AuthenticateRequest authenticateRequest){
		System.out.println("Inside authenticate");
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getEmpId(), authenticateRequest.getPassword()));
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getEmpId());
		System.out.println("Inside authenticate2");
		String generateToken = jwtUtil.generateToken(userDetails);
		System.out.println(generateToken);
		return new ResponseEntity<AuthenticateResponse>(new AuthenticateResponse(generateToken),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> registerEmployee(@RequestBody Employee employee){
		System.out.println("inside add");
		Employee registerEmployee = employeeService.registerEmployee(employee);
		if (registerEmployee!=null) {
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Not Success",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getEmployee(@RequestParam String empId){
		Employee employee = employeeService.getEmployee(empId);
		if (employee!=null) {
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Not Sucess",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/getParticularEmp")
	public ResponseEntity<?> getParticularEmployee(HttpServletRequest request){
		String header = request.getHeader("Authorization");
		String jwt=header.substring(7);
		Employee particularEmployee = employeeService.getParticularEmployee(employeeJWTUtil.extractUsername(jwt));
		if (particularEmployee!=null) {
			return new ResponseEntity<Employee>(particularEmployee,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee>(particularEmployee,HttpStatus.BAD_REQUEST);
		}
	}

}
