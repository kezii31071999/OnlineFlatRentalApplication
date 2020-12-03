package com.ofr.exception;

public class AddLandlordException extends RuntimeException {
	
	
	/**
	 * If the landlord does not enter name or his age is less than 18, AddLandlordException is thrown
	 */
	private static final long serialVersionUID = 1L;

	public AddLandlordException(String msg) {
		super(msg);
	}
	

}
