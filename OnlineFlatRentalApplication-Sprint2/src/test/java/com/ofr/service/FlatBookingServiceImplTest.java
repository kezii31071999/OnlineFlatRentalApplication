package com.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ofr.dao.FlatBookingDao;
import com.ofr.exception.DuplicateFlatBookingException;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.model.Flat;
import com.ofr.model.Tenant;
import com.ofr.model.FlatAddress;
import com.ofr.model.FlatBooking;


@TestInstance(Lifecycle.PER_CLASS)
class FlatBookingServiceImplTest {

	@Mock
	FlatBookingServiceImpl service;
	
	@Mock
	FlatBookingDao dao;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	void testAddFlatBooking() throws DuplicateFlatBookingException{
		FlatAddress flatAdd = new FlatAddress(200, "Kezii", "CBE", "TN", 628004, "INDIA");
		Flat flat = new Flat(9000.0f, flatAdd, "YES");
		Tenant tenant = new Tenant(100, 20, flatAdd);
		LocalDate bookingFromDate = LocalDate.of(2020, 8, 10);
		LocalDate bookingToDate = LocalDate.of(2020, 11, 11);
		FlatBooking flatbook = new FlatBooking(543, tenant, flat, bookingFromDate, bookingToDate);
		service.addFlatBooking(flatbook);
		assertEquals(flatbook.getBookingFromDate(), LocalDate.of(2020,8,10));
		verify(service,times(1)).addFlatBooking(flatbook);
	}

	@Test
	void testUpdateFlatBooking() throws FlatBookingNotFoundException{
		FlatAddress flatAdd = new FlatAddress(201, "abcd", "cbe", "Tn", 628005, "India");
		Flat flat = new Flat(5000.0f, flatAdd, "yes");
		Tenant tenant = new Tenant(104, 21, flatAdd);
		LocalDate bookingFromDate = LocalDate.of(2020, 9, 10);
		LocalDate bookingToDate = LocalDate.of(2020, 12, 11);
		FlatBooking flatbook = new FlatBooking(544, tenant, flat, bookingFromDate, bookingToDate);
		service.addFlatBooking(flatbook);
		flatbook.setBookingFromDate(bookingFromDate);
		service.updateFlatBooking(flatbook);
		assertEquals(flatbook.getBookingFromDate(), LocalDate.of(2020,9,10));
		verify(service,times(1)).updateFlatBooking(flatbook);

	}

	@Test
	void testDeleteFlatBooking() throws FlatBookingNotFoundException{
		FlatAddress flatAdd = new FlatAddress(201, "abc", "cbe", "Tn", 628005, "India");
		Flat flat = new Flat(5000.0f, flatAdd, "yes");
		Tenant tenant = new Tenant(104, 21, flatAdd);
		LocalDate bookingFromDate = LocalDate.of(2020, 9, 10);
		LocalDate bookingToDate = LocalDate.of(2020, 12, 11);
		FlatBooking flatbook = new FlatBooking(544, tenant, flat, bookingFromDate, bookingToDate);
		service.addFlatBooking(flatbook);
		service.deleteFlatBooking(flatbook);
		verify(service,times(1)).deleteFlatBooking(flatbook);
		assertNotNull(service);
	}

	@Test
	void testViewFlatBooking() throws FlatBookingNotFoundException{
		FlatAddress flatAdd = new FlatAddress(200, "Kezii", "CBE", "TN", 628004, "INDIA");
		Flat flat = new Flat(9000.0f, flatAdd, "YES");
		Tenant tenant = new Tenant(100, 20, flatAdd);
		LocalDate bookingFromDate = LocalDate.of(2020, 8, 10);
		LocalDate bookingToDate = LocalDate.of(2020, 11, 11);
		FlatBooking flatbook = new FlatBooking(543, tenant, flat, bookingFromDate, bookingToDate);
		service.addFlatBooking(flatbook);
		Optional<FlatBooking> viewByIdList1 = Optional.ofNullable(flatbook);
		when(service.viewFlatBooking(543)).thenReturn(viewByIdList1);
		Optional<FlatBooking> viewByIdList2 = service.viewFlatBooking(543);
		assertEquals(viewByIdList1,viewByIdList2);
	}

	@Test
	void testViewAllFlatBooking() {
		List<FlatBooking> flatTest= new ArrayList<FlatBooking>();
		FlatAddress flatAdd = new FlatAddress(200, "Kezii", "CBE", "TN", 628004, "INDIA");
		Flat flat = new Flat(9000.0f, flatAdd, "YES");
		Tenant tenant = new Tenant(100, 20, flatAdd);
		LocalDate bookingFromDate = LocalDate.of(2020, 8, 10);
		LocalDate bookingToDate = LocalDate.of(2020, 11, 11);
		FlatBooking flatbook = new FlatBooking(543, tenant, flat, bookingFromDate, bookingToDate);
		
		flatTest.add(flatbook);
		when(service.viewAllFlatBooking()).thenReturn(flatTest);
		List<FlatBooking> flatTest1= service.viewAllFlatBooking();
		assertEquals(1,flatTest1.size());
		verify(service,times(1)).viewAllFlatBooking();
	}

}
