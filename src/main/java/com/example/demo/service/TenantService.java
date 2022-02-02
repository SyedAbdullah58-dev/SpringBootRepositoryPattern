package com.example.demo.service;

import com.example.demo.model.Tenant;
import com.example.demo.repository.ITenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TenantService {

    public final ITenantRepository tenantRepository;
@Autowired
    public TenantService(ITenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> getTenant() {
    return tenantRepository.findAll();
    }

    public boolean addTenant(Tenant tenant) {
        try {
            tenantRepository.save(tenant);
        } catch (Exception e) {
            e.printStackTrace();
        return false;
        }
    return true;
    }

    public boolean deleteTenant(Long tenantId) {

        try {
            tenantRepository.deleteById(tenantId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean updateTenant(Long tenantId, Tenant tenant) {
        try {
            Tenant updatedTenant=tenantRepository.findById(tenantId).get();
            updatedTenant.setTenantAddress(tenant.getTenantAddress());
            updatedTenant.setTenantName(tenant.getTenantName());
            updatedTenant.setTenantDescription(tenant.getTenantAddress());
            updatedTenant.setTenantContact(tenant.getTenantDescription());
            tenantRepository.save(tenant);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
