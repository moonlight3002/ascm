package com.nest.ascm.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nest.ascm.utility.GlobalResponse;
import com.nest.ascm.utility.Response;

@ControllerAdvice
public class ExceptionInterceptor {

	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<Response> handleAllExceptions(DataNotFoundException ex) {
		return GlobalResponse.resFail(ex.getCode(), ex.getMessage());
	}
	
	@ExceptionHandler(CustomDataIntegrityException.class)
	public final ResponseEntity<Response> handleDataIntegrityViolationException(CustomDataIntegrityException ex) {
		return GlobalResponse.resFail(ex.getCode(), ex.getMessage());
	}
}
