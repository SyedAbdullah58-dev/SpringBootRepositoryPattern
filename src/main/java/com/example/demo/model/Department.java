package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String departmentName;

    @JsonBackReference
@ManyToMany(targetEntity = Employee.class,cascade = CascadeType.MERGE,mappedBy = "departmentSet")
private Set<Employee> employeeSet=new HashSet<Employee>();

    public Department() {
    }

    public Department(Long id, String departmentName, Set<Employee> employeeSet) {
        this.id = id;
        this.departmentName = departmentName;
        this.employeeSet = employeeSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}