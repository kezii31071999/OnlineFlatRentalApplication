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

import com.ofr.model.Tenant;
import com.ofr.service.TenantServiceImpl;

/*This controller class used to get response for add,update,delete and view the tenant details
 * @author Sathya K
*/
@RestController
@Validated
@RequestMapping("/tenant")
public class TenantController {
	@Autowired
	TenantServiceImpl service;
	
	public static final Logger log = Logger.getLogger(TenantController.class.getName());

	/*
	 * This method is used for add the tenant and it give the response for boolean type
	 * @param tenant
	 */
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@Valid@RequestBody Tenant tenant) {
		log.info("Started adding Tenant Details ");
		
		service.addTenant(tenant);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		log.info("Tenant Details added");
		return responseEntity;
	}
	
	/*
	 * This method is used for update the tenant and it give the response in boolean type
	 * @param tenant
	 * exception TenantNotFoundException 
	 */

	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@Valid@RequestBody Tenant tenant){
		log.info("Started updating Tenant Details ");
		
		 service.updateTenant(tenant);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		 log.info("Tenant Details Updated");

		return responseEntity;
	}
	
	/*
	 * This method is used to delete the tenant and it returns boolean type 
	 * @param tenant 
	 * exception throws TenantNotFoundException
	 */

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestBody Tenant tenant){
		log.info("Started Deleting Tenant Details ");
		
		 service.deleteTenant(tenant);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		
		log.info("Tenant Details Deleted");
		return responseEntity;
}
	/*
	 * This method is used for view all tenant details and it return tenant list
	 * @param tenant
	 */
	@GetMapping("/all") 
	public ResponseEntity<List<Tenant>> viewAllTenant() {
		log.info("Started Viewing all Tenant Details ");
		
		List<Tenant> list = service.viewAllTenant();
		
		log.info("All Tenant Details Viewed");
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	/*
	 * This method is used for find tenant id and it return the details for specific id
	 * @param tenant
	 * exception throws TenantNotFoundException
	 */
	
	@GetMapping("/find/{tenantId}")
	public ResponseEntity<Optional<Tenant>> getTenantById(@PathVariable("tenantId") Integer id){
		log.info("Started Searching Tenant Details by ID ");
		
		Optional<Tenant> tenant = service.viewTenant(id);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Optional<Tenant>> responseEntity = new ResponseEntity(tenant, HttpStatus.OK);
		
		log.info("Tenant Details Viewed");
		return responseEntity;
	}
	
	/*
	 * This method is used for find exists tenant id and it return boolean type
	 * @param tenant
	 * exception TenantNotFoundException
	 */
	
	@GetMapping("/exists/{tenantId}")
	public ResponseEntity<Boolean> getExistsById(@PathVariable("tenantId") Integer id){
		log.info("Started Validation for Tenant");
		
		boolean tenant = service.validateTenant(id);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(tenant, HttpStatus.OK);
		
		log.info("Validation Ended");
		return responseEntity;
	}
}
