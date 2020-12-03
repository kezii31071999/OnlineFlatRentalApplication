package com.ofr.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ofr.dao.FlatDao;
import com.ofr.exception.FlatNotFoundException;
import com.ofr.exception.ValidFlatDetailsException;
import com.ofr.model.Flat;
import com.ofr.model.FlatAddress;

@TestInstance(Lifecycle.PER_CLASS)
class FlatServiceImplTest {
	
	@Mock
	private FlatServiceImpl flatService;
	
	@Mock
	private FlatDao flatDao;
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testAddFlat() throws ValidFlatDetailsException{
        FlatAddress flatAdd = new FlatAddress(11, "street", "city", "state", 639, "country");
        Flat flat = new Flat(6000f,flatAdd,"yes");
        flatService.addFlat(flat);
        assertEquals("street",flat.getFlatAddress().getStreet());
        assertEquals("city",flat.getFlatAddress().getCity());
        assertEquals("state",flat.getFlatAddress().getState());
	}

	@Test
	void testUpdateFlat() throws FlatNotFoundException{
		 FlatAddress flatAdd = new FlatAddress(11, "street", "city", "state", 639, "country");
	     Flat flat = new Flat(6000f,flatAdd,"yes");
	     flat.setCost(7000f);
	     flatService.updateFlat(flat);
	     assertEquals(7000f,flat.getCost());
	}

	@Test
	void testDeleteFlat() throws FlatNotFoundException,ValidFlatDetailsException{
		FlatAddress flatAdd= new FlatAddress(11, "street", "city", "state", 639, "country");
		Flat flat = new Flat(8000f,flatAdd,"yes");
		flat=flatService.addFlat(flat);
		Flat flat1 = flatService.deleteFlat(flat);
		assertNull(flat1);
	}

	@Test
	void testViewFlat() throws FlatNotFoundException,ValidFlatDetailsException{
		FlatAddress flatAdd = new FlatAddress(200, "gan", "CBE", "TN", 628004, "INDIA");
		Flat flat = new Flat(9000.0f, flatAdd, "YES");
		flatService.addFlat(flat);
		Optional<Flat> viewByIdList1 = Optional.ofNullable(flat);
		when(flatService.viewFlat(310)).thenReturn(viewByIdList1);
		Optional<Flat> viewByIdList2 = flatService.viewFlat(310);
		assertEquals(viewByIdList1,viewByIdList2);
		
	}

	@Test
	void testViewAllFlat() {
		List<Flat> flat = flatService.viewAllFlat();
		assertNotNull(flat);
	}

	@Test
	void testViewAllFlatByCost() {
		List<Flat> flat = flatService.viewAllFlatByCost(7000f,"yes");
		assertNotNull(flat);
	}

}
