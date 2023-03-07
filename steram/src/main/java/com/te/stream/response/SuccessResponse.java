package com.te.stream.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessResponse<T> {
	
	     
	    private Integer count;

		private Boolean error;
		
		private String msg;
		
		private Object data;
		  
		private List list;
		
		private T t;
	

}
