package com.springboot.jpa.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8519005430880414886L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
