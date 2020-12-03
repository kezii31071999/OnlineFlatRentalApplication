package com.ofr.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofr.dao.FlatDao;
import com.ofr.exception.FlatNotFoundException;
import com.ofr.exception.ValidFlatDetailsException;
import com.ofr.model.Flat;

@Service
@Transactional
public class FlatServiceImpl implements FlatService{

	@Autowired
	private FlatDao flatDao;
	
	
	public FlatDao getFlatDao() {
		return flatDao;
	}

	public void setFlatDao(FlatDao flatDao) {
		this.flatDao = flatDao;
	}

	String flatIdNotFound="Flat Id not found Exception";
	
	/*
	 * This method is used for add the flat
	 * return type Flat
	 * @param flat
	 * exception ValidFlatDetailsException
	 */
	@Override
	public Flat addFlat(Flat flat){
		if(flat.getCost()==null || flat.getAvailability().isEmpty() ) {
			throw new ValidFlatDetailsException("Enter the valid details");
		}
		else
		{
		return getFlatDao().save(flat);
		}
	}

	/*
	 * This method is used for update the flat
	 * return type Flat
	 * @param flat
	 * exception FlatNotFoundException
	 */
	@Override
	public Flat updateFlat(Flat flat){
		Optional<Flat> flat1=flatDao.findById(flat.getFlatId());
		if(flat1.isPresent()) {	
			return getFlatDao().save(flat);
		}
		else
		{
			throw new FlatNotFoundException(flatIdNotFound);
		}
	}

	/*
	 * This method is used for delete the flat
	 * return type Flat
	 * @param flat
	 * exception FlatNotFoundException
	 */
	@Override
	public Flat deleteFlat(Flat flat){
		Optional<Flat> flat1=flatDao.findById(flat.getFlatId());
		if(flat1.isPresent())
		{	
			getFlatDao().delete(flat);
		}
		else
		{
			throw new FlatNotFoundException(flatIdNotFound);
		}
		 return flat;
	}

	/*
	 * This method is used to view the flat by id
	 * return type Flat
	 * @param flat
	 * exception FlatNotFoundException
	 */
	@Override
	public Optional<Flat> viewFlat(Integer id){
	    Optional<Flat> flat1=getFlatDao().findById(id);
	    if(flat1.isPresent())
	    {
	    	return flat1;
	    }
	    else
	    {
	    	throw new FlatNotFoundException(flatIdNotFound);
	    }
	}

	/*
	 * This method is used to view all the flat
	 * return type list
	 */
	@Override
	public List<Flat> viewAllFlat() {
		return getFlatDao().findAll();
	}

	/*
	 * This method is used to view the available flats by cost 
	 * return type List
	 * @param cost,availability
	 */
	@Override
	public List<Flat> viewAllFlatByCost(Float cost, String availability) {
		return flatDao.viewAllFlatByCost(cost, availability);
	}

}


