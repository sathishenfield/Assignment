package com.te.userflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.userflow.entity.Appointment;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment, Integer>{

}
