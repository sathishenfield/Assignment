package com.te.userflow.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.userflow.entity.Doctor;
import com.te.userflow.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
	
	private String name;

	private Integer age;

	private String email;

	private String sex;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate bookingDate;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime bookingTime;
	

}
