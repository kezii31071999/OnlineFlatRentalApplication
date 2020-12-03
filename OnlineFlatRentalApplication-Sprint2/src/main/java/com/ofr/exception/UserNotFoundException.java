package com.ofr.exception;

/*
 * @Author : Sathya Sivam R
*/
public class UserNotFoundException extends RuntimeException{

	/**
	 * Default Serial version
	 */
	private static final long serialVersionUID = 1L;

	
	/*
	 * Parameterized constructor for UserNotFoundException class
	 */
	
	public UserNotFoundException(String message)
	{
		super(message);
	}
}
