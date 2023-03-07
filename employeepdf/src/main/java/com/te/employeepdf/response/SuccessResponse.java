package com.te.employeepdf.response;

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
	
	private List list;
	


}
