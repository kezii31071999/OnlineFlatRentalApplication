package com.ofr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofr.model.Landlord;


@Repository
public interface LandlordDao extends JpaRepository<Landlord, Integer>{
	
	/*
	 * This dao interface extends JpaRepository to get predefined functionalities
	 * 
	 */
}
