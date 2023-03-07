package com.te.mongodb.service;

import java.util.List;

import com.te.mongodb.entity.Employee;
import com.te.mongodb.repository.EmployeeDAO;

public interface EmployeeService {
	
	public Employee registerEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Boolean deleteEmployee(Integer id);
	
	public Employee updateEmployee(Employee employee);

}
