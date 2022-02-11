package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;

public interface IEmployeeService {
    Page<Employee> getEmployee(int page, int size);
}
