package com.ofr.dto;

import java.time.LocalDate;

public class FlatBookingDto {

	private Integer bookingNo;

	private TenantDto tenantId;

	private FlatDto flat;

	private LocalDate bookingFromDate;

	private LocalDate bookingToDate;

	public FlatBookingDto(Integer bookingNo, TenantDto tenantId, FlatDto flat, LocalDate bookingFromDate,
			LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.tenantId = tenantId;
		this.flat = flat;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}

	public FlatBookingDto() {
		super();
	}

	public Integer getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}

	public TenantDto getTenantId() {
		return tenantId;
	}

	public void setTenantId(TenantDto tenantId) {
		this.tenantId = tenantId;
	}

	public FlatDto getFlat() {
		return flat;
	}

	public void setFlat(FlatDto flat) {
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
		return "FlatBooking [bookingNo=" + bookingNo + ", tenantId=" + tenantId + ", flat=" + flat
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}

}
