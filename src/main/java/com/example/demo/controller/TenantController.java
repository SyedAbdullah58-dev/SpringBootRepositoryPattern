package com.example.demo.controller;

import com.example.demo.model.Tenant;
import com.example.demo.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tenant")
public class TenantController {
public final TenantService tenantService;

    public TenantController(TenantService tenantService) {
       this.tenantService = tenantService;
    }

    @GetMapping
    public List<Tenant> getTenant(){
return tenantService.getTenant();
    }
    @PostMapping
    public String addTenant(@RequestBody Tenant tenant) {
        boolean status=false;
        status= tenantService.addTenant(tenant);
    if(status==true)
        return "Tenant with ID = "+tenant.getTenantId() + " added";
    else
        return "Unable to add Tenant";
    }
    @DeleteMapping(path = "delete/{tenantId}")
    public String deleteTenant(@PathVariable("tenantId")Long tenantId){
        boolean status=false;
        status=tenantService.deleteTenant(tenantId);
        if(status==true)
            return "The Tenant with ID = " +tenantId +" deleted successfully";
        else
            return "Failed to delete Tenant :(";

    }
    @PutMapping(path = "update/{tenantId}")
    public String updateTenant(@PathVariable Long tenantId,@RequestBody Tenant tenant){
boolean status=false;
        status=tenantService.updateTenant( tenantId,tenant);
if(status==true)
    return "Tenant updated";
else
    return "Unable to update";

    }
}
