package com.springboot.jpa.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 4992347853746929309L;
	
	public BadRequestException(String message) {
		super(message);
	}

}
