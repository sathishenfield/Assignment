package com.te.beanvalidation.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.beanvalidation.entity.Employee;
import com.te.beanvalidation.repository.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee registerEmployee(Employee employee) {
	
		return dao.save(employee);
	}

}
