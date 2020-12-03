package com.ofr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.dao.LandlordDao;
import com.ofr.exception.AddLandlordException;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.model.Landlord;
@Service("landlordService")
@Transactional
public class LandlordServiceImpl implements LandlordService {
	
	@Autowired
	LandlordDao landlordDao;
	
	public LandlordDao getLandlordDao() {
		return landlordDao;
	}

	public void setLandlordDao(LandlordDao landlordDao) {
		this.landlordDao = landlordDao;
	}
	
	String message = "No Landlord found for given ID";
	
	/*
	 * addLandlord method is used to add the landlord details
	 * @param - landlord
	 * returns landlord
	 * Exception - AddLandlordException
	 */
	
	@Override
	public Landlord addLandlord(Landlord landlord){
		
		if(landlord.getLandlordName().isEmpty() || landlord.getLandlordAge()<18) {
			throw new AddLandlordException("Enter valid details");
		}
		
		return getLandlordDao().save(landlord);
		
	}

	/*
	 * updateLandlord method is used to update landlord details
	 * @param - landlord
	 * returns landlord
	 * Exception - LandlordNotFoundException
	 * 
	 */	
	
	@Override
	public Landlord updateLandlord(Landlord landlord) {
		Optional<Landlord> landlord1 = getLandlordDao().findById(landlord.getLandlordId());
		if(landlord1.isPresent()) {
			return getLandlordDao().save(landlord);
		}
		else {
			throw new LandlordNotFoundException(message);
		}
		
	}
	
	/*
	 * deleteLandlord is used to delete landlord details
	 * @param - landlord
	 * returns landlord
	 * Exception - LandlordNotFoundException
	 */	
	
	@Override
	public Landlord deleteLandlord(Landlord landlord) {
		Optional<Landlord> landlord1 = getLandlordDao().findById(landlord.getLandlordId());
		if(landlord1.isPresent()) {
			getLandlordDao().delete(landlord);
			return landlord;
		}
		else {
			throw new LandlordNotFoundException(message);
		}
	}

	/*
	 * viewLandlord method is used to view landlord details by ID
	 * @param - landlordId
	 * returns landlord details by ID
	 * EXception - LandlordNotFoundException
	 */	
	
	@Override
	public Optional<Landlord> viewLandlord(Integer landlordId){
		Optional<Landlord> landlord1 = getLandlordDao().findById(landlordId);
		if(landlord1.isPresent()) {
			return getLandlordDao().findById(landlordId);
		}
		else {
			throw new LandlordNotFoundException(message);
		}
	}

	/*
	 * viewAllLandlord method is used to view all landlord details
	 * returns list of landlords
	 */	
	
	@Override
	public List<Landlord> viewAllLandlord() {
		return getLandlordDao().findAll();
		
	}

}
