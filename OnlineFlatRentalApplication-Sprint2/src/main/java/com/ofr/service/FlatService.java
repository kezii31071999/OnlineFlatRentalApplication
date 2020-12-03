package com.ofr.service;

import java.util.List;
import java.util.Optional;

import com.ofr.model.Flat;

public interface FlatService {

	public Flat addFlat(Flat flat);
	
	public Flat updateFlat(Flat flat);
	
	public Flat deleteFlat(Flat flat);
	
	public Optional<Flat> viewFlat(Integer id);
	
	public List<Flat> viewAllFlat();
	
	public List<Flat> viewAllFlatByCost(Float cost,String availability);
}
