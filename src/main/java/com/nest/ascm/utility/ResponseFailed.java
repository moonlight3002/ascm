package com.nest.ascm.utility;

import lombok.Data;

@Data
public class ResponseFailed implements Response{
	private String status="ERR";
	private String code="";
	private String message;
}
