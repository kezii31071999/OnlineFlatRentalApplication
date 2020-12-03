package com.ofr.service;

import java.util.List;
import java.util.Optional;

import com.ofr.model.Landlord;

public interface LandlordService {
	
	public Landlord addLandlord(Landlord landlord);
	public Landlord updateLandlord(Landlord landlord);
	public Landlord deleteLandlord(Landlord landlord);
	public Optional<Landlord> viewLandlord(Integer landlordId);
	public List<Landlord> viewAllLandlord();

	

}
