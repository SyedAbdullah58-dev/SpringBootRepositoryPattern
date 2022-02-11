package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity

@Table(name = "tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false)
    private Long tenantId;
    private String tenantName;
    private String tenantContact;
    private String tenantAddress;
    private String tenantDescription;



    @OneToMany(mappedBy = "tenant",cascade = CascadeType.REMOVE)
private Set<Employee> employeeSet=new HashSet<Employee>();

    public Tenant() {
    }
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantContact() {
        return tenantContact;
    }

    public void setTenantContact(String tenantContact) {
        this.tenantContact = tenantContact;
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress;
    }

    public String getTenantDescription() {
        return tenantDescription;
    }

    public void setTenantDescription(String tenantDescription) {
        this.tenantDescription = tenantDescription;
    }

}