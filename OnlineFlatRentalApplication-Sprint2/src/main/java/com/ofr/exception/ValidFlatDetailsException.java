package com.ofr.exception;

public class ValidFlatDetailsException extends RuntimeException{

	/*
	 *  Default serial version parameter
	 */
	private static final long serialVersionUID = 1L;


	/*
	 * Parameterized constructor for ValidFlatDetailsException class
	 */
	public ValidFlatDetailsException(String message) {
		super(message);
	}
}
