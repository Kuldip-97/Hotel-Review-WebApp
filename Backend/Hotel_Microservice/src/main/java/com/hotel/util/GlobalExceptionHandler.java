package com.hotel.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.exceptions.HotelException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<APIResponse> HotelExceptionHandler(HotelException e){
		APIResponse api = new APIResponse();
		String message = e.getMessage();
		api.setMessage(message);
		api.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIResponse>(api, HttpStatus.BAD_REQUEST);
	}
}
