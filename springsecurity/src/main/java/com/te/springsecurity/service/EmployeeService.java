package com.te.springsecurity.service;

import java.util.List;

import com.te.springsecurity.entity.Employee;

public interface EmployeeService {
	
	public Employee registerEmployee(Employee employee);
	
	public Employee getEmployee(String id);
	
    public Employee getParticularEmployee(String id);

}
