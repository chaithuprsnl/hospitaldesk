package com.hospital.fdesk.exception;

public class ErrorMessage {

	private String message;
	private String description;

	/**
	 * @param description
	 * @param message
	 */
	public ErrorMessage(String message, String description) {
		super();
		this.description = description;
		this.message = message;
	}

	public ErrorMessage() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
