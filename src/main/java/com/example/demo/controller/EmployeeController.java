package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
   public final EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
/*
    public List<Employee> getEmployee(@RequestParam(defaultValue = "2") Long id,@RequestParam(required = false) String designation ){
employeeService.getSingleEmployee(id,designation);

    }*/
@RequestMapping(path = "/pageable",method = RequestMethod.GET)
    Page<Employee> getEmployee(Pageable pageable){
        return employeeService.getEmployee(pageable);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){

        return  employeeService.getEmployee();
    }
    @DeleteMapping(path = "delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return "Employee with ID =" +employeeId+" Deleted";
    }
    @PostMapping
public String registerNewEmployee(@RequestBody Employee employee){
 employeeService.addNewEmployee(employee);
 return "Employee with ID = "+employee.getEmployeeId() +" Added";
}
@PutMapping(path = "/update/{employeeId}")
public String updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
    boolean status=false;
    status=employeeService.updateEmployee( employeeId, employee);
    if(status==true)
return "Employee updated";
    else return "unable to update employee";
}


}
