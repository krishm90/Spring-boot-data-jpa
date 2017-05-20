package com.springboot.jpa.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.exception.BadRequestException;
import com.springboot.jpa.exception.UserNotFoundException;

@ControllerAdvice  
@RestController  
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class) 
    public String handleException(BadRequestException e){  
        return e.getMessage();
    }
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UserNotFoundException.class) 
    public String handleException(UserNotFoundException e){  
        return e.getMessage();
    }
}
