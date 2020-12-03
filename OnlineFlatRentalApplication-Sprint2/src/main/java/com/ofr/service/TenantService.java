package com.ofr.service;

import java.util.List;
import java.util.Optional;

import com.ofr.model.Tenant;

public interface TenantService {
	
	public Tenant addTenant(Tenant tenant);

	public Tenant updateTenant(Tenant tenant);

	public Tenant deleteTenant(Tenant tenant);

	public Optional<Tenant> viewTenant(Integer tenantId);

	public List<Tenant> viewAllTenant();

	public boolean validateTenant(Integer tenantId);

	

}
