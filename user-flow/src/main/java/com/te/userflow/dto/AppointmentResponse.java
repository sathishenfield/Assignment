package com.te.userflow.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

	private String name;

	private Integer age;

	private String email;

	private String sex;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate bookingDate;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime bookingTime;

	private DoctorDTO doctor;

}
