package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    private final IDepartmentRepository departmentRepository;

@Autowired
    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> getDepartment() {
  return   departmentRepository.findAll();
    }

    public boolean addDepartment(Department department) {

        try {
            departmentRepository.save(department);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
 return true;
}

    public boolean updateDepartment(Long departmentId, Department department) {
        try {
            Department updatedDepartment=departmentRepository.findById(departmentId).get();
            updatedDepartment.setDepartmentName(department.getDepartmentName());
            departmentRepository.save(updatedDepartment);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
return  true;
    }

    public boolean deleteDepartment(Long departmentId) {
        try {
            departmentRepository.deleteById(departmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
