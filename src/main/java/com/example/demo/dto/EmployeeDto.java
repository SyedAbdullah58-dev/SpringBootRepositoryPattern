package com.example.demo.dto;

import com.example.demo.model.Employee;
import com.example.demo.model.Tenant;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import java.util.List;

@Data

public class EmployeeDto {
    private Long employeeId;
    private int salary;
    private String designation;
    User user;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Tenant tenant;
   /* @Autowired
    private EntityManager entityManager;
    public int getTotalRecords(){
       return entityManager.createStoredProcedureQuery("getTotalRecords").getFirstResult();
    }*/
}




