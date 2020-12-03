package com.ofr.dto;

public class FlatAddressDto {

	private Integer houseNo;
	private String street;
	private String city;
	private String state;
	private Integer pin;
	private String country;
	
	
	public FlatAddressDto(Integer houseNo, String street, String city, String state, Integer pin, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}

	public FlatAddressDto() {
		super();
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 

	@Override
	public String toString() {
		return "FlatAddress [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", country=" + country + "]";
	}

}
