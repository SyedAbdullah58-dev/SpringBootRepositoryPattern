package com.example.demo.dto;

import com.example.demo.model.Tenant;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
@Data
public class EmployeeDto {
    private Long employeeId;
    private int salary;
    private String designation;
    User user;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Tenant tenant;
}



