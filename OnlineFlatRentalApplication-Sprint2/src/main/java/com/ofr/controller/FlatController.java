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

import com.ofr.model.Flat;
import com.ofr.service.FlatService;

/*
 * This class used to get response for add,update,delete and view the flat details
 * @author Naveena 
 */

@RestController
@RequestMapping("/flats")
@Validated
public class FlatController {

	@Autowired
	private FlatService flatService;

	public FlatService getFlatService() {
		return flatService;
	}

	public void setFlatService(FlatService flatService) {
		this.flatService = flatService;
	}
	
	public static final Logger log = Logger.getLogger(FlatController.class.getName());

	/*
	 * This method is used for add the flat and it give the response in boolean type
	 * @param flat
	 * exception ValidFlatDetailsException
	 */
	@PostMapping("/add")
	public ResponseEntity<Boolean> addFlat(@Valid @RequestBody Flat flat){
		
		log.info("Started adding Flat Details ");
		
		getFlatService().addFlat(flat);
		@SuppressWarnings({"rawtypes","unchecked"})
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true,HttpStatus.OK);
		
		log.info("Flat Details added");
		return responseEntity;
	}
	
	/*
	 * This method is used for update the flat and it give the response in boolean type
	 * @param flat
	 * exception FlatNotFoundException
	 */
	@SuppressWarnings({"rawtypes","unchecked"})
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateFlat(@Valid @RequestBody Flat flat){
		log.info("Started updating Flat Details ");

		 getFlatService().updateFlat(flat);

		 log.info("Flat Details Updated");

		return new ResponseEntity(true,HttpStatus.OK);
		
	}
	
	/*
	 * This method is used for delete the flat and it give the response in boolean type
	 * @param flat
	 * exception FlatNotFoundException
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteFlat(@RequestBody Flat flat){
		log.info("Started Deleting Flat Details ");

		getFlatService().deleteFlat(flat);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		 
		log.info("Flat Details Deleted");
		 return responseEntity;
	}
	
	/*
	 * This method is used for find the flat by its id and it return the flat details for specific id
	 * @param id
	 * exception FlatNotFoundException
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Flat>> viewFlat(@PathVariable("id") Integer id){
		log.info("Started Searching Flat Details by ID ");

		Optional<Flat> entity = getFlatService().viewFlat(id);
		
		log.info("Flat Details Viewed");
		return new ResponseEntity<>(entity,new HttpHeaders(),HttpStatus.OK);
	}
	
	/*
	 * This method is used for get all the flat and it return the flat details 
	 */
	@GetMapping("/all")
	 public ResponseEntity<List<Flat>> viewAllFlat(){
			log.info("Started Viewing all Flat Details ");
	
		    List<Flat> list = getFlatService().viewAllFlat();
		    	
		    log.info("All Flat Details Viewed");
		    return new ResponseEntity<>(list,new HttpHeaders(),HttpStatus.OK);
	    }
	
	/*
	 * This method is used for find the flat by its id and it return the flat details for specific id
	 * @param cost, availability
	 */

	@GetMapping("/find/{cost}/{availability}")
	 public ResponseEntity<List<Flat>> viewAllFlatByCost(@PathVariable Float cost ,@PathVariable String availability){
		
			log.info("Started searching Flat Details by Cost and Availability");

	    	List<Flat> list = getFlatService().viewAllFlatByCost(cost, availability);

	    	log.info("Flat Details viewed by Cost and Availability");
	    	return new ResponseEntity<>(list,new HttpHeaders(),HttpStatus.OK);
	    }
}
