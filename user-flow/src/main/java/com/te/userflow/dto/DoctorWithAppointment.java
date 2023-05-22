package com.te.userflow.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorWithAppointment {
	
	private String name;

	private Long mobNo;

	private String specialization;
	
	private List<AppointmentDTO> todayList;
	
	private List<AppointmentDTO> tommorrowList;

}
