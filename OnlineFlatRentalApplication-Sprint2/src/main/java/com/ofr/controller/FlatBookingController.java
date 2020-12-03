package com.ofr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.model.FlatBooking;
import com.ofr.service.FlatBookingService;

/**
 * This is a controller class for FlatBooking with methods of
 * Get,Post,Update,Delete..
 * 
 * @author Abigail Keziah
 * 
 **/
@RestController
@RequestMapping("/flatBooking")
@Validated
public class FlatBookingController {

	@Autowired
	private FlatBookingService service;

	public FlatBookingService getService() {
		return service;
	}

	public void setService(FlatBookingService service) {
		this.service = service;
	}

	public static final Logger log = Logger.getLogger(FlatBookingController.class.getName());

	/**
	 * This method is to view all the available FlatBooking using getMapping 
	 * 
	 * @param List<FlatBooking>
	 * 
	 **/

	@GetMapping("/all") // http://localhost:7880/flatBooking/all
	public ResponseEntity<List<FlatBooking>> viewAllFlatBooking() {
		log.info("Started Viewing all Flat Booking Details ");
		
		List<FlatBooking> list = getService().viewAllFlatBooking();
		
		log.info("All Flat Booking Details Viewed");
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * This method is to find FlatBooking according to the id specified using getMapping
	 * 
	 * @param Integer bookingNo
	 * 
	 **/

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<FlatBooking>> viewFlatBooking(@PathVariable("bookingNo") Integer bookingNo) {
		log.info("Started Searching FlatBooking Details by ID ");
		
		Optional<FlatBooking> entity = getService().viewFlatBooking(bookingNo);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Optional<FlatBooking>> responseEntity = new ResponseEntity(entity, HttpStatus.OK);
		
		log.info("FlatBooking Details Viewed");
		return responseEntity;
	}

	/**
	 * This method is to add the FlatBooking using PostMapping
	 * 
	 * @param flatbook(instance)
	 * 
	 **/

	@PostMapping("/add")
	public ResponseEntity<Boolean> addFlatBooking(@Valid @RequestBody FlatBooking flatBook) {
		log.info("Started adding FlatBooking Details ");
		
		getService().addFlatBooking(flatBook);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		log.info("FlatBooking Details added");
		return responseEntity;

	}

	/**
	 * This method is to update the FlatBooking using PutMapping
	 * 
	 * @param flatbook(instance)
	 * 
	 **/

	@PutMapping("/update")
	public ResponseEntity<Boolean> updateFlatBooking(@Valid @RequestBody FlatBooking flatBook) {
		log.info("Started updating FlatBooking Details ");
		
		getService().updateFlatBooking(flatBook);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		 log.info("FlatBooking Details Updated");

		return responseEntity;
	}

	/**
	 * This method is to delete the FlatBooking using DeleteMapping
	 * 
	 * @param flatbook(instance)
	 * 
	 **/
	@DeleteMapping("/remove")
	public ResponseEntity<Boolean> deleteFlatBooking(@RequestBody FlatBooking flatBook) {
		log.info("Started Deleting FlatBooking Details ");
		
		getService().deleteFlatBooking(flatBook);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		log.info("FlatBooking Details Deleted");
		return responseEntity;
	}

}
