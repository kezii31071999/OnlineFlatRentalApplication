package com.ofr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofr.model.FlatBooking;

/**
 * This interface is to get the inbuilt CRUD operations for FlatBooking
 * 
 * @param JpaRepository <FlatBooking,Integer>
 * 
 **/

@Repository
public interface FlatBookingDao extends JpaRepository<FlatBooking, Integer> {

}
