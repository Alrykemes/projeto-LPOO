package com.managepro.exceptions;

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
