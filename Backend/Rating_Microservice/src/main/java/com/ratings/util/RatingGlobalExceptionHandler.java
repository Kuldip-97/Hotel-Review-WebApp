package com.ratings.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ratings.exception.RatingException;

@RestControllerAdvice
public class RatingGlobalExceptionHandler {
	
	@ExceptionHandler(RatingException.class)
	public ResponseEntity<APIResponse> RatingExceptionHandler(RatingException re){
		APIResponse api = new APIResponse();
		String message = re.getMessage();
		api.setMessage(message);
		api.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIResponse>(api, HttpStatus.BAD_REQUEST);
	}
}
