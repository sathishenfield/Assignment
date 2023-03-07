package com.te.employeepdf.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.te.employeepdf.entity.Employee;
import com.te.employeepdf.response.SuccessResponse;
import com.te.employeepdf.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/registerEmployee")
	public ResponseEntity<SuccessResponse> registerEmployee(@RequestBody Employee employee){
		
		Employee registerEmployee = service.registerEmployee(employee);
		if (registerEmployee!=null) {
			
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().
					error(false).data(registerEmployee).build(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().
					error(true).data(registerEmployee).build(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("pdf/generate")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		

		String headerKey = "Content_Disposition";
		String headerValue = "attatchment; filename=pdf_" + currentDateTime + ".pdf";

		response.setHeader(headerKey, headerValue);
		service.export(response);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<SuccessResponse> searchEmployee(@PathVariable Integer id){
		Employee searchEmployee = service.searchEmployee(id);
		if (searchEmployee!=null) {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().
					error(false).data(searchEmployee).build(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().
					error(true).data(searchEmployee).build(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("pdf/generate/search/{id}")
	public void generatePdfSearch(HttpServletResponse response,@PathVariable Integer id) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		

		String headerKey = "Content_Disposition";
		String headerValue = "attatchment; filename=pdf_" + currentDateTime + ".pdf";

		response.setHeader(headerKey, headerValue);
		service.exportSearch(response,id);
	}

}
