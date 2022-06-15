package com.smartech.vendorportal.utils;

import org.springframework.http.HttpStatus;

public class TaskException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpSatatus;
	
	public TaskException(String message) {
		super();
		this.message = message;
	}
	public TaskException(HttpStatus httpSatatus,String message) {
		super();
		this.message = message;
		this.httpSatatus = httpSatatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpSatatus() {
		return httpSatatus;
	}
	public void setHttpSatatus(HttpStatus httpSatatus) {
		this.httpSatatus = httpSatatus;
	}
	
	

}
