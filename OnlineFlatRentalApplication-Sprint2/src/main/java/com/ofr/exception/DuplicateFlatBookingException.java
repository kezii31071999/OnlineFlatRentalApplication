package com.ofr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is to check DuplicateEntries of FlatBooking
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Empty list")
public class DuplicateFlatBookingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateFlatBookingException(String message) {
		super(message);
	}

}
