package com.ofr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ofr.model.Landlord;
import com.ofr.service.LandlordServiceImpl;

/*
 * This controller  class used to get response for add,update,delete and view the landlord details
 * @author Santhosh N
*/
@RestController
@RequestMapping("/landlord")
@Validated
public class LandlordController {
	
	@Autowired
	LandlordServiceImpl landlordService;
	
	public LandlordServiceImpl getLandlordService() {
		return landlordService;
	}

	public void setLandlordService(LandlordServiceImpl landlordService) {
		this.landlordService = landlordService;
	}
	
	public static final Logger log = Logger.getLogger(LandlordController.class.getName());


	/*
	 * when add request is received, business logic for respective method is performed
	 * returns true if added
	 * 
	 */	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@Valid @RequestBody Landlord landlord) {
		log.info("Started adding Landlord Details ");
		
		getLandlordService().addLandlord(landlord);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		log.info("Landlord Details added");
		return responseEntity;
		
	}
	
	/*
	 * when update request is received, business logic for respective method is performed
	 * returns true if updated
	 * 
	 */
	
	@PutMapping("/update")
	public ResponseEntity<Landlord> update(@Valid @RequestBody Landlord landlord) {
		log.info("Started updating Landlord Details ");
		
		landlord = getLandlordService().updateLandlord(landlord);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Landlord> responseEntity = new ResponseEntity(landlord, HttpStatus.OK);
		
		 log.info("Landlord Details Updated");
		return responseEntity;
		
	}
	
	/*
	 * when remove request is received, business logic for respective method is performed
	 * returns true if removed
	 * 
	 */
	
	@DeleteMapping("/remove")
	public ResponseEntity<Boolean> deleteLandlord(@RequestBody Landlord landlord) {
		log.info("Started Deleting Landlord Details ");
		
		getLandlordService().deleteLandlord(landlord);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		log.info("Landlord Details Deleted");
		return responseEntity;
		
	}
	
	/*
	 * when find request is received, business logic for respective method is performed
	 * returns landlord details by ID
	 * 
	 */
	
	@GetMapping("/find/{landlordId}")
	public ResponseEntity<Optional<Landlord>> viewById(@PathVariable("landlordId") Integer landlordId) {
		log.info("Started Searching Landlord Details by ID ");
		
		Optional<Landlord> landlord = getLandlordService().viewLandlord(landlordId);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Optional<Landlord>> responseEntity = new ResponseEntity(landlord, HttpStatus.OK);
		
		log.info("Landlord Details Viewed");
		return responseEntity;
		
	}
	
	/*
	 * when findAll request is received, business logic for respective method is performed
	 * returns list of landlords
	 * 
	 */
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Landlord>> viewAllLandlord() {
		log.info("Started Viewing all Landlord Details ");
		
		List<Landlord> landlordList = getLandlordService().viewAllLandlord();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<List<Landlord>> responseEntity = new ResponseEntity(landlordList, HttpStatus.OK);
		
		log.info("All Landlord Details Viewed");
		return responseEntity;
	}
	
	

}
