package com.te.springsecurity.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class AuthenticateRequest {
	
	private String empId;
	
	private String password;

}
