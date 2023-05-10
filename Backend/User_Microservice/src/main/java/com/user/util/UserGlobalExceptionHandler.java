package com.user.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.exception.UserException;

@RestControllerAdvice
public class UserGlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<APIResponse> UserExceptionHandler(UserException ue){
		APIResponse api = new APIResponse();
		String message = ue.getMessage();
		api.setMessage(message);
		api.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIResponse>(api, HttpStatus.BAD_REQUEST);
	}
}
