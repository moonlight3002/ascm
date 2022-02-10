package com.nest.ascm.exceptions;

import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message = "Data not found";
	private String code = "E404";

	public DataNotFoundException() {
        super();
    }
	
	public DataNotFoundException(String message) {
        super();
        this.message = message;
    }
}
