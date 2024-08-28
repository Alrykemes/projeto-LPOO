package com.managepro.exceptions;

@SuppressWarnings("serial")
public class ValidacaoException extends Exception {
	
	public ValidacaoException() {
		super();
	}
	
	public ValidacaoException(String message) {
		super(message);
	}
	
	public ValidacaoException(String message, Throwable cause) {
		super(message,cause);
	}
	
}
