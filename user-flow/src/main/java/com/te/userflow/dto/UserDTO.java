package com.te.userflow.dto;

import java.util.List;

import com.te.userflow.entity.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String name;

	private String password;

	private String email;
	
}
