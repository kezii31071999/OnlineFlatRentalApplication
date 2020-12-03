package com.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofr.dao.FlatBookingDao;
import com.ofr.exception.DuplicateFlatBookingException;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.model.FlatBooking;

/**
 * This class is to perform the CRUD operations for FlatBooking
 * 
 * 
 **/
@Service("flatBookingService")
@Transactional
public class FlatBookingServiceImpl implements FlatBookingService {

	@Autowired
	private FlatBookingDao flatBookingDao;

	public FlatBookingDao getFlatBookingDao() {
		return flatBookingDao;
	}

	public void setFlatBookingDao(FlatBookingDao flatBookingDao) {
		this.flatBookingDao = flatBookingDao;
	}

	/**
	 * This class is to add the FlatBooking using bookingNo
	 * 
	 * @param bookingNo
	 * 
	 **/
	@Override
	public FlatBooking addFlatBooking(FlatBooking flatbook) {
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(flatbook.getBookingNo());
		if (flatbook1.isPresent()) {
			throw new DuplicateFlatBookingException("The FlatBooking Details Already Exists");
		}
		return getFlatBookingDao().save(flatbook);
	}

	/**
	 * This class is to update the FlatBooking using bookingNo
	 * 
	 * @param bookingNo
	 * 
	 **/
	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatbook) {
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(flatbook.getBookingNo());
		if (flatbook1.isPresent()) {
			return getFlatBookingDao().save(flatbook);
		} else {
			throw new FlatBookingNotFoundException("Booking of Flat is not Updated");
		}
	}

	/**
	 * This class is to delete the FlatBooking using bookingNo
	 * 
	 * @param bookingNo
	 * 
	 **/
	@Override
	public FlatBooking deleteFlatBooking(FlatBooking flatbook) {
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(flatbook.getBookingNo());
		if (flatbook1.isPresent()) {
			getFlatBookingDao().delete(flatbook);
			return flatbook;
		} else {
			throw new FlatBookingNotFoundException("Booking of Flat is not Deleted");
		}

	}

	/**
	 * This class is to view the FlatBooking using bookingNo
	 * 
	 * @param bookingNo
	 * 
	 **/
	@Override
	public Optional<FlatBooking> viewFlatBooking(Integer bookingNo) {
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(bookingNo);
		if (flatbook1.isPresent()) {
			return getFlatBookingDao().findById(bookingNo);
		} else {
			throw new FlatBookingNotFoundException("Booking of Flat is not Deleted");
		}

	}

	/**
	 * This class is to view all the FlatBooking
	 * 
	 * @param List<FlatBooking>
	 * 
	 **/
	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		return getFlatBookingDao().findAll();
		
	}

}
