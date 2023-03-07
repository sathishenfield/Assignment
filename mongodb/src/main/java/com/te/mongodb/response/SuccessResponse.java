package com.te.mongodb.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {
	
	private Boolean error;
	
	private Object data;
	
	private String msg;
	
	private List list;

}
