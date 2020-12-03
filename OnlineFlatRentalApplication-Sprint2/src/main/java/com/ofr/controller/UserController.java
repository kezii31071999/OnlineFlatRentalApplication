package com.ofr.controller;


/*
 * This class used to get response for add,update,delete and view the flat details 
 * 	@author Sathya Sivam R
 */

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

import com.ofr.model.User;
import com.ofr.service.UserService;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired
	private UserService service;
	
	 public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public static final Logger log = Logger.getLogger(UserController.class.getName());

	/*
	 * This method is used for get all the user and it return the user details 
	 */
	@GetMapping("/all")//http://localhost:7878/user/all
	    public ResponseEntity<List<User>> fetchAllUsers() {
			log.info("Started Viewing all User Details ");
			
	        List<User> list = getService().viewAllUser();
	        
	        log.info("All User Details Viewed");
	        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);//200,json
	    }
	 
	/*
	 * This method is used for add the user and it give the response in boolean type
	 * @param user
	 * exception RegisterationException, DuplicateUserRecordException
	 */
	
	 @PostMapping("/adduser")
		 public ResponseEntity<Boolean> create(@Valid @RequestBody User user){
		 	log.info("Started adding User Details ");
		 
			getService().addUser(user);
			@SuppressWarnings({ "rawtypes", "unchecked" })
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			
			log.info("User Details added");
			return responseEntity;
		 }
	 
	 /*
	 * This method is used for update the user and it give the response in boolean type
	 * @param user
	 * exception UserNotFoundException
	 */
	 @PutMapping("/updateuser")
		 public ResponseEntity<Boolean> update(@Valid @RequestBody User user){
		 	log.info("Started updating User Details ");
		 
			 getService().updateUser(user);
			 @SuppressWarnings({ "rawtypes", "unchecked" })
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			 
			 log.info("User Details Updated");
			 return responseEntity;
		 }
	 
	 /*
	 * This method is used for delete the user and it give the response in boolean type
	 * @param user
	 * exception UserNotFoundException
	 */
	 @DeleteMapping("/removeuser")
		 public ResponseEntity<Boolean> delete(@RequestBody User user){
		 	log.info("Started Deleting User Details ");
			
		 	getService().removeUser(user);
			 @SuppressWarnings({ "rawtypes", "unchecked" })
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			 
			 log.info("User Details Deleted");
			 return responseEntity;
		 }
	 
	 /*
	 * This method is used for find the user by its id and it return the user details for specific id
	 * @param userId
	 * exception UserNotFoundException
	 */
	 @GetMapping("/find/{userId}")
	 	public ResponseEntity<Optional<User>> findTraineeById(@PathVariable("userId") Integer userId) {
		 log.info("Started Searching User Details by ID ");
	 		Optional<User> user = getService().viewUser(userId);
	 		@SuppressWarnings({ "rawtypes", "unchecked" })
			ResponseEntity<Optional<User>> responseEntity = new ResponseEntity(user, HttpStatus.OK);
	 		
	 		log.info("User Details Viewed");
	 		return responseEntity;
	 	}
	 
	 /*
	 * This method is used for validate the username and password
	 * @param userId
	 * exception UserNotFoundException
	 */
	 @GetMapping("/validate/{id}/{userName}/{password}")
		 public String validateUser(@PathVariable Integer id, @PathVariable String userName, @PathVariable String password)
		 {
		 	 log.info("User Validation");
			 return getService().validateUser(id, userName, password);
		 }
	 
	 /*
	 * This method is used for update password
	 * @param userId
	 * exception UserNotFoundException
	 */
	 @PutMapping("/updatePass/{newPass}")
		 public String updatePassword(@RequestBody User user, @PathVariable String newPass)
		 {
			 log.info("Updating Password");
			 return getService().updatePassword(user, newPass);
		 }
}
