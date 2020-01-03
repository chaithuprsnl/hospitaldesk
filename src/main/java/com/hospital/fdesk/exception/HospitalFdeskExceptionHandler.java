package com.hospital.fdesk.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HospitalFdeskExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(InvalidInputException.class)
	public final ResponseEntity<ErrorMessage> handleException(Exception e){
		
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(),"Please enter a valid input"); 
		return new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
