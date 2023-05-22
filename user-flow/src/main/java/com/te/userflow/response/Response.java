package com.te.userflow.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

	private String msg;

	private Object data;

	private Boolean err;

	private List list;

}
