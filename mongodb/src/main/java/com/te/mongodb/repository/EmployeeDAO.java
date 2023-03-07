package com.te.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.mongodb.entity.Employee;

@Repository
public interface EmployeeDAO extends MongoRepository<Employee, Integer>{

}
