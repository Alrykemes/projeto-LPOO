package com.managepro.exceptions;

@SuppressWarnings("serial")
public class ExcecaoDeNegocios extends Exception {
	
	public ExcecaoDeNegocios() {
		super();
	}
	
	public ExcecaoDeNegocios(String message) {
		super(message);
	}
	
	public ExcecaoDeNegocios(String message, Throwable cause) {
		super(message,cause);
	}
	
}