package com.ofr.exception;
/*
 * TenantNotFoundException class
 */
public class TenantNotFoundException extends RuntimeException {
	
	/*
	 * Default serial version parameter
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * parameterized constructor for TenantNotFoundExeption 
	 */
	public TenantNotFoundException(String msg) {
		super(msg);
	}

}
