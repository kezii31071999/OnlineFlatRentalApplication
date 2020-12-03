package com.ofr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** This is an entity class for FlatAddress with getters and setters and constructor
 *  @author Abigail Keziah
 * 
 **/

@Entity
@Table(name="FlatAddress")
public class FlatAddress {

	@Id
	@GeneratedValue
	@Column(name = "flatAddressId")
	private Integer flatAddressId;
	@Column(name="house_No" , length=15)
	private Integer houseNo;
	@Column(name="Street" , length=15)
	private String street;
	@Column(name="City" , length=15)
	private String city;
	@Column(name="State" , length=15)
	private String state;
	@Column(name="Pin" , length=15)
	private Integer pin;
	@Column(name="Country" , length=15)
	private String country;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="flatAddress")
	private Flat flat;
	
	@OneToOne(targetEntity = FlatBooking.class)
	private FlatBooking flatBook;
	
	/*
	 * Parameterized constructor for flat address
	 */
	public FlatAddress(Integer houseNo, String street, String city, String state, Integer pin, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}

	/*
	 * Default constructor for flat address
	 */
	public FlatAddress() {
		
	}

	/*
	 * Getter and setter methods for all the parameters of flat address model class
	 */
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
