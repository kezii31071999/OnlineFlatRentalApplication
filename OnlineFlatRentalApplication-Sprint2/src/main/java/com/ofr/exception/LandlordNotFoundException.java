package com.ofr.exception;

public class LandlordNotFoundException extends RuntimeException {
	
	/**
	 * If landlord is not found, it throws LandlordNotFoundException
	 */
	
	private static final long serialVersionUID = 1L;

	public LandlordNotFoundException(String s) {
		super(s);
	}


}
