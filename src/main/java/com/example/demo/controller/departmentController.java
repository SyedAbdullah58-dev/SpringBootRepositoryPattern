package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping(path = "api/v1/department")
public class departmentController {
    public final DepartmentService departmentService;

    @Autowired
    public departmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }
    @PostMapping
    public String addDepartment(@RequestBody Department department){
        boolean status=false;
        if(!(department.getDepartmentName()==null))
        status=departmentService.addDepartment(department);
        if (status==true)
        return "Department : "+department.getDepartmentName()+" Added";
        else
            return "Unable to add department :(";
    }
    @PutMapping(path = "update/{departmentId}")
    public String updateDepartment(@PathVariable Long departmentId,@RequestBody Department department){
        boolean status=false;
      if(departmentId!=null && department.getDepartmentName()!=null)
      status=  departmentService.updateDepartment(
                departmentId,department
        );
        if (status==true)
            return "Department with ID : "+departmentId +" updated Successfully";
        else
        return "Unable to update Department" ;
    }
    @DeleteMapping(path = "delete/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId")Long departmentId){
        boolean status=false;
        if(departmentId!=null)
       status= departmentService.deleteDepartment(departmentId);
   if(status==true)
       return "department with ID : "+departmentId+" deleted";
   else
       return  "unable to delete the department :(";

    }


}
