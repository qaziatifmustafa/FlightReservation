package com.reservation.flight;
/**
 * 
 * @author Qazi Atif
 *
 */
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e){
		System.out.println("Here is some exxception : "+e);
		return "NullPointerException";
	}
	@ExceptionHandler(value=IOException.class)
	public String IOPointerException(Exception e){
		System.out.println("Here is some IO exxception : "+e);
		return "IOException";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e){
		System.out.println("Here is some Generic exxception : "+e);
		return "Exception";
	}

}
