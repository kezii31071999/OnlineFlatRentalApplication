package com.ofr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.dao.TenantDao;
import com.ofr.exception.TenantNotFoundException;
import com.ofr.model.Tenant;

@Service("tenantservice")
@Transactional
public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantDao dao;
    String tenantNotFound = "tenant id not Found";
    
    /*
     * This method is used for add tenant and return type tenant
     * @param tenant
     */
	@Override
	public Tenant addTenant(Tenant tenant) {
		dao.save(tenant);
		return tenant;
	}
	
	
	/*
	 * This method is used for update the tenant and return type tenant 
	 * @param tenant
	 * exception TenantNotFoundException
	 */
	@Override
	public Tenant updateTenant(Tenant tenant) {
		Optional<Tenant> tenant1 = dao.findById(tenant.getTenantId());
		if(tenant1.isPresent())
		{
			return dao.save(tenant);
		}
		else
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
	}
	
	/*
	 * This method is used for delete tenant and return type tenant
	 * @param
	 * exception TenantNotFoundException
	 */
	@Override
	public Tenant deleteTenant(Tenant tenant)
	{
		Optional<Tenant> tenant1 = dao.findById(tenant.getTenantId());
		if(tenant1.isPresent())
		{
			  dao.delete(tenant);
		}
		else
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
		return tenant;
	}
	
	
	/*
	 * This method is used for view tenant by its tenant id and it return type tenant 
	 * @param tenant
	 * exception TenantNotFoundException
	 */
	@Override
	public Optional<Tenant> viewTenant(Integer tenantId){
	Optional<Tenant> tenant= dao.findById(tenantId);
		if(tenant.isPresent())
		{
			return tenant;
			
		}
		else
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
	}
	
	
	/*
	 * This method is used for view all tenant details and return type find all
	 * @param tenant
	 */
	@Override
	public List<Tenant> viewAllTenant() {
		return dao.findAll();
	}
	
	
	/*
	 * This method is used for validate tenant by its tenant id and return type boolean
	 * @param tenant
	 * exception TenantNotFoundException
	 */
	@Override
	public boolean validateTenant(Integer tenantId){
		boolean tenant=dao.existsById(tenantId);
		if(tenant)
		{
			return true;
		}
		else 
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
		
	}


}
