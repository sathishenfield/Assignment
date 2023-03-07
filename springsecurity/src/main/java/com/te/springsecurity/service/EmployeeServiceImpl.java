package com.te.springsecurity.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springsecurity.DAO.EmployeeDAO;
import com.te.springsecurity.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee registerEmployee(Employee employee) {
		System.out.println("Inside register");
		return dao.save(employee);
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = dao.findById(id);
		Employee employee=null;
		if (findById.isPresent()) {
			employee=findById.get();
			return employee;
		}
		else {
			return employee;
		}
	}

	@Override
	public Employee getParticularEmployee(String id) {
		Optional<Employee> findById = dao.findById(id);
		
		if (findById.isPresent()) {
			return findById.get();
		}
		return findById.get();
	}

}
