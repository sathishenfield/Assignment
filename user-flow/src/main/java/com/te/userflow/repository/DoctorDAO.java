package com.te.userflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.userflow.entity.Doctor;

@Repository
public interface DoctorDAO extends JpaRepository<Doctor, Integer>{
	
	  public List<Doctor> findByName(String name);

}
