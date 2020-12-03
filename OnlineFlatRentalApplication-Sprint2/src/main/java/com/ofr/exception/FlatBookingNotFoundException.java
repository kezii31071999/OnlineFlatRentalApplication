package com.ofr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is to check FlatBooking is available
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlatBookingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlatBookingNotFoundException(String message) {
		super(message);
	}
}
