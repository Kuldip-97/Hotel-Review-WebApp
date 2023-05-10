package com.hotel.exceptions;


public class HotelException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public HotelException() {
		super();
	}
	public HotelException(String message) {
		super(message);
	}
}
