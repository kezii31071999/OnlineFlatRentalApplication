package com.ofr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/** This is an entity class for Tenant with getters and setters and constructor
 *  @author Sathya K
 * 
 **/

@Entity
@Table(name="Tenant")

public class Tenant {

	@Id
	@Column(name="tenantId" , length=15)
	private Integer tenantId;
	@Column(name="tenantAge" , length=15)
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Flataddress")
	private FlatAddress taddress;
	
	public Tenant(Integer tenantId, Integer age, FlatAddress taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}  

	public Tenant() {
		
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
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
		return "Tenant [tenantId=" + tenantId + ", age=" + age + ", taddress=" + taddress + "]";
	}
	
	
	
}
