package com.ofr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofr.model.Tenant;

/**
 * This interface is to get the inbuilt CRUD operations for Tenant
 * 
 * @param JpaRepository <Tenant,Integer>
 * 
 **/

@Repository
public interface TenantDao extends JpaRepository<Tenant,Integer> {

}
