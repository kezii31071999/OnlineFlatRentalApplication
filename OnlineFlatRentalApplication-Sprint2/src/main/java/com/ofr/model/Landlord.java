package com.ofr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/*
*	@author : Santhosh N
*	Module  : Landlord
*
*/

@Entity
@Table(name = "Landlord")
public class Landlord  {
	
	/*
	 * Properties of Landlord
	 */

	@Id
	@GeneratedValue
	@Column(name = "Landlord_Id", length = 15)
	private Integer landlordId;
	@Column(name = "Landlord_Name", length = 15)
	@Size(min = 3, message = "Enter valid name")
	private String landlordName;
	@Column(name = "Landlord_Age", length = 15)
	@Min(value = 18, message = "Your age is below 18")
	private Integer landlordAge;
	@OneToMany(targetEntity=Flat.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Landlord_Id", referencedColumnName="Landlord_Id")
	 private List<Flat> flatList;
	public Landlord() {

	}

	/*
	 * Parameterised Constructor
	 */
	
	public Landlord(String landlordName, Integer landlordAge, List<Flat> flatList) {
		super();

		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}

	/*
	 * Getters and Setters
	 * 
	 */	
	
	public Integer getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
	}
	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public Integer getLandlordAge() {
		return landlordAge;
	}

	public void setLandlordAge(Integer landlordAge) {
		this.landlordAge = landlordAge;
	}

	public List<Flat> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}

}
