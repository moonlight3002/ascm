package com.nest.ascm.utility;

import lombok.Data;

@Data
public class ResponseSuccess implements Response{
	private String status="OK";
	private String code="";
	private Object data;
	
}
