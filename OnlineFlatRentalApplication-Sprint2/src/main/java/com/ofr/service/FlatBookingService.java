package com.ofr.service;

import java.util.List;
import java.util.Optional;

import com.ofr.model.FlatBooking;

/**
 * This is a interface for FlatBooking with methods of add,update,delete..
 * 
 * @author Abigail Keziah
 * 
 **/

public interface FlatBookingService {
	FlatBooking addFlatBooking(FlatBooking flatBook) ;

	FlatBooking updateFlatBooking(FlatBooking flatBook);

	FlatBooking deleteFlatBooking(FlatBooking flatBook);

	Optional<FlatBooking> viewFlatBooking(Integer bookingNo);

	List<FlatBooking> viewAllFlatBooking();

}
