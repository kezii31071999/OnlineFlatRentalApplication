package com.ofr.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofr.model.User;

/**
 * This interface is to get the inbuilt CRUD operations for User
 * 
 * @param JpaRepository <User,Integer>
 * 
 **/

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
