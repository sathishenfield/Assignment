package com.te.employeepdf.service;

import java.io.IOException;

import com.lowagie.text.DocumentException;
import com.te.employeepdf.entity.Employee;

import jakarta.servlet.http.HttpServletResponse;

public interface EmployeeService {
	
	public Employee registerEmployee(Employee employee);

	public void export(HttpServletResponse response) throws DocumentException, IOException;
	
	public Employee searchEmployee(Integer id);
	
	public void exportSearch(HttpServletResponse response,Integer id) throws DocumentException, IOException;
}
