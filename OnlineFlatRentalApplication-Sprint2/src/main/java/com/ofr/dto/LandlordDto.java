package com.ofr.dto;

import java.util.List;
import com.ofr.model.Flat;

public class LandlordDto {

	private Integer landlordId;
	private String landlordName;
	private Integer landlordAge;
	private List<Flat> flatList;
	
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
		return "LandlordDto [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge="
				+ landlordAge + ", flatList=" + flatList + "]";
	}
	

}
