package com.nest.ascm.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResponse {
	public static ResponseEntity<Response> resSuccess(Object data) {
		ResponseSuccess res = new ResponseSuccess();
		res.setData(data);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	public static ResponseEntity<Response> resSuccess() {
		return new ResponseEntity<Response>(HttpStatus.OK);
	}

	public static ResponseEntity<Response> resFail(String code, String msg) {
		ResponseFailed res = new ResponseFailed();
		res.setMessage(msg);
		res.setCode(code);
		return new ResponseEntity<Response>(res, HttpStatus.BAD_REQUEST);
	}

}
