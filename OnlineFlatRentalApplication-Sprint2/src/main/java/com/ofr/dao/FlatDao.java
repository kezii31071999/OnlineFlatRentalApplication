package com.ofr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ofr.model.Flat;

/**
 * This interface is to get the inbuilt CRUD operations for Flat
 * 
 * @param JpaRepository <Flat,Integer>
 * 
 **/

@Repository
public interface FlatDao extends JpaRepository<Flat, Integer>{

	@Query("select f from Flat f where f.cost=?1 and f.availability=?2")
	public List<Flat> viewAllFlatByCost(Float cost, String availability);
}
