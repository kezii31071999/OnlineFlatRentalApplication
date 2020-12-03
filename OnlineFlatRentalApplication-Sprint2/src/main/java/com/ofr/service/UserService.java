package com.ofr.service;

/*
 * Flat Service Interface
 *
 * @Author : Sathya Sivam R
 * 
*/

import java.util.List;
import java.util.Optional;

import com.ofr.model.User;

public interface UserService {

	public User addUser(User user);
	
	public User updateUser(User user);

	public User removeUser(User user);

	public Optional<User> viewUser(Integer userId);
	
	public List<User> viewAllUser();
		
	public String validateUser(Integer userId, String userName,String password); 
	
	public String updatePassword(User user,String newpass);

}
