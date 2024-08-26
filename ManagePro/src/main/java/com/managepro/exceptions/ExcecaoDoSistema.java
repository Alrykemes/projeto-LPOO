package com.managepro.exceptions;

@SuppressWarnings("serial")
public class ExcecaoDoSistema extends Exception {
	
	public ExcecaoDoSistema() {
		super();
	}
	
	public ExcecaoDoSistema(String message) {
		super(message);
	}
	
	public ExcecaoDoSistema(String message, Throwable cause) {
		super(message,cause);
	}
	
}