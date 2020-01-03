package com.hospital.fdesk.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

	public InvalidInputException(String message) {
		super();
		this.message = message;
	}

	public InvalidInputException() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
