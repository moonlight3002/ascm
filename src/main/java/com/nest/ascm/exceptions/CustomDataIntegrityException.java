package com.nest.ascm.exceptions;

import lombok.Data;

@Data
public class CustomDataIntegrityException extends RuntimeException{
	private String message = "Data Integrity Error";
	private String code = "E422";

	public CustomDataIntegrityException() {
        super();
    }
	
	public CustomDataIntegrityException(String message) {
        super();
        this.message = message;
    }
}
