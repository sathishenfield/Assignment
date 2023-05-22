package com.te.userflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticateResponse {
	
	private String jwtToken;

}
