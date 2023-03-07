package com.te.employeepdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.employeepdf.entity.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
