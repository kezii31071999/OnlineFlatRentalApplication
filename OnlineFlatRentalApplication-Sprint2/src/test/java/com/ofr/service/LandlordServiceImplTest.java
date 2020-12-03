package com.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ofr.exception.AddLandlordException;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.model.Flat;
import com.ofr.model.FlatAddress;
import com.ofr.model.Landlord;
@TestInstance(Lifecycle.PER_CLASS)
class LandlordServiceImplTest {
	
	@Mock
	LandlordServiceImpl landlordService;
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void testAddLandlord() throws AddLandlordException {
		FlatAddress flatAddress = new FlatAddress(1, "1street", "cbe", "tn", 641025, "india");
		Flat flat = new Flat(100.0f, flatAddress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord("Sandy", 21, flatList);
		landlordService.addLandlord(landlord);
		verify(landlordService, times(1)).addLandlord(landlord);
		assertEquals("Sandy", landlord.getLandlordName());
	}

	@Test
	void testUpdateLandlord() throws AddLandlordException, LandlordNotFoundException {
		FlatAddress flatAddress = new FlatAddress(2,"1street", "cbe", "tn", 641025, "india");
		Flat flat = new Flat(100.0f, flatAddress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord("Sandy", 21, flatList);
		landlordService.addLandlord(landlord);
		landlord.setLandlordName("Santhosh");
		landlordService.updateLandlord(landlord);
		verify(landlordService, times(1)).updateLandlord(landlord);
		assertEquals("Santhosh", landlord.getLandlordName());
	}

	@Test
	void testDeleteLandlord() throws LandlordNotFoundException, AddLandlordException {
		FlatAddress flatAddress = new FlatAddress(3, "1street", "cbe", "tn", 641025, "india");
		Flat flat = new Flat( 100.0f, flatAddress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord("Sandy", 21, flatList);
		landlordService.addLandlord(landlord);
		Landlord landlord1 = landlordService.deleteLandlord(landlord);
		verify(landlordService, times(1)).deleteLandlord(landlord);
		assertNull(landlord1);

	}
	
	@Test
	void testViewAllLandlord() throws AddLandlordException {
		FlatAddress flatAddress = new FlatAddress(4, "1street", "cbe", "tn", 641025, "india");
		Flat flat = new Flat(100.0f, flatAddress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord("Sandy", 21, flatList);
		landlordService.addLandlord(landlord);
		
		List<Landlord> landlordList = new ArrayList<Landlord>();
		landlordList.add(landlord);
		when(landlordService.viewAllLandlord()).thenReturn(landlordList);
		@SuppressWarnings("unused")
		List<Landlord> traineeList = landlordService.viewAllLandlord();
		assertEquals(1, landlordList.size());
		verify(landlordService, times(1)).viewAllLandlord();
		
	}

	@Test
	void testViewLandlord() throws AddLandlordException, LandlordNotFoundException {
		FlatAddress flatAddress = new FlatAddress(5, "1street", "cbe", "tn", 641025, "india");
		Flat flat = new Flat( 100.0f, flatAddress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord("Sandy", 21, flatList);
		landlordService.addLandlord(landlord);
		Optional<Landlord> landlord1 = Optional.ofNullable(landlord);
		when(landlordService.viewLandlord(60)).thenReturn(landlord1);
		Optional<Landlord> landlord2 = landlordService.viewLandlord(60);
		assertEquals(landlord1, landlord2);

		
		
	}


}
