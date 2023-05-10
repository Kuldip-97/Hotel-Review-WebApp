package com.ratings.exception;

public class RatingException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RatingException() {}

	public RatingException(String message) {
		super(message);
	}
	
}
