package com.te.userflow.service;

import java.util.List;

import com.te.userflow.dto.DoctorDTO;
import com.te.userflow.dto.DoctorWithAppointment;
import com.te.userflow.entity.Doctor;

public interface DoctorService {

	public List<DoctorDTO> getDoctorByName(String name);

	public List<DoctorDTO> getAllDoctor();
	
	public List<DoctorWithAppointment> getDoctorWithAppointment(String doctorName);

}
