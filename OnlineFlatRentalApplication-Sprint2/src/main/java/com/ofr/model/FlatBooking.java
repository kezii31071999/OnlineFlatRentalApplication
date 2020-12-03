package com.ofr.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/** This is an entity class for FlatBooking with getters and setters and constructor
 *  @author Abigail Keziah
 * 
 **/

@Entity
@Table(name = "FlatBooking")
public class FlatBooking {

	
	@Id
	@Column(name="BookingNo",length=15)
	@Min(value =1,message="Id should be positive and greater than 1")
	private Integer bookingNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenantId")
	private Tenant tenantId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLATID")
	private Flat flat;
	
	@Column(name="booking_from_date")
	@NotNull(message = "Enter the Valid BookingFromDate")
	private LocalDate bookingFromDate;
	
	@Column(name="booking_to_date")
	@NotNull(message = "Enter the Valid BookingToDate")
	private LocalDate bookingToDate;

	/*
	 * Default constructor for flat booking
	 */
	public FlatBooking() {

	}

	/*
	 * Parameterized constructor for flat booking
	 */
	public FlatBooking(Integer bookingNo, Tenant tenantId, Flat flat, LocalDate bookingFromDate,
			LocalDate bookingToDate) {
		this.bookingNo = bookingNo;
		this.tenantId = tenantId;
		this.flat = flat;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}

	/*
	 * Getter and setter methods for all the parameters of flat booking model class
	 */
	public Integer getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Tenant getTenantId() {
		return tenantId;
	}

	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	public LocalDate getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	@Override
	public String toString() {
		return "FlatBooking [bookingNo=" + bookingNo /* + ", tenantId=" + tenantId + ", flat=" + flat */
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
}
