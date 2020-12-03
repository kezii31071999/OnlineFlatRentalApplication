package com.ofr.dto;

public class FlatDto {
	
	private Integer flatId;
	
	private Float cost;
	
	private String availability;

	private FlatAddressDto flatAddress;
	
	public FlatDto(Integer flatId, Float cost, String availability) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.availability = availability;
	}

	public FlatDto() {
		super();
	}

	public Integer getFlatId() {
		return flatId; 
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public FlatAddressDto getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(FlatAddressDto flatAddress) {
		this.flatAddress = flatAddress;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", availability="
				+ availability + "]";
	}
	
	
	
}
