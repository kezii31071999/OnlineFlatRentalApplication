package com.ofr.exception;

public class FlatNotFoundException extends RuntimeException{

	/*
	 * Default serial version parameter
	 */
	private static final long serialVersionUID = 1L;

	
	/*
	 * Parameterized constructor for FlatNotFoundException class
	 */
	public FlatNotFoundException(String message) {
		super(message);
	}
}
