package com.ofr.dto;



import com.ofr.model.FlatAddress;

public class TenantDto {

	private Integer tenantId;
	private Integer age;
	private FlatAddress taddress;
	public TenantDto(Integer tenantId, Integer age, FlatAddress taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}
	public TenantDto() {
		super();
		
	}
	public Integer getTenantId() {
		return tenantId;
	}
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public FlatAddress getTaddress() {
		return taddress;
	}
	public void setTaddress(FlatAddress taddress) {
		this.taddress = taddress;
	}
	@Override
	public String toString() {
		return "TenantDto [tenantId=" + tenantId + ", age=" + age + ", taddress=" + taddress + "]";
	}
	
}
