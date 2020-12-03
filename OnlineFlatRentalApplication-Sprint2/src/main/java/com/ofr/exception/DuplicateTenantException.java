package com.ofr.exception;

public class DuplicateTenantException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateTenantException(String msg)
	{
		super(msg);
	}

}
