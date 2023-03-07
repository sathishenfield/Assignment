package com.te.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mongodb.entity.Employee;
import com.te.mongodb.repository.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee registerEmployee(Employee employee) {
		
		return dao.save(employee);
		
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return dao.findAll();
	}

	@Override
	public Boolean deleteEmployee(Integer id) {
		Optional<Employee> findById = dao.findById(id);
		
		if (findById.isPresent()) {
			dao.deleteById(id);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	
		Integer empId = employee.getEmpId();
		String empName = employee.getEmpName();
		Integer age = employee.getAge();
	    Optional<Employee> findById = dao.findById(empId);
	    Employee employee2 = findById.get();
	   
	    if (findById.isPresent()) {
			employee2.setAge(age);
			employee2.setEmpName(empName);
			employee2.setEmpId(empId);
			dao.save(employee2);
			return employee2;
		}
	    else {
	    	return employee2;
	    }
	}

}
