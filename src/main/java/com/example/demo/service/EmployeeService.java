package com.example.demo.service;


import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
private final IEmployeeRepository employeeRepository;
@Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository =employeeRepository;
    }
    public static void addEmployee(Employee employee) {
        System.out.println(employee);
    }

    public Page<Employee> getEmployee(int page, int size){
    return employeeRepository.findAll(PageRequest.of(page,size));
    }


    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
   boolean exists= employeeRepository.existsById(id);
    if(!exists){
        throw  new IllegalStateException();
    }
    else
    employeeRepository.deleteById(id);

}

    public boolean updateEmployee(Long employeeId, Employee employee) {

        try {
            Employee updatedEmp=employeeRepository.findById(employeeId).get();
            updatedEmp.setUser(employee.getUser());
            updatedEmp.setSalary(employee.getSalary());
            updatedEmp.setDesignation(employee.getDesignation());
            updatedEmp.setDepartmentSet(employee.getDepartmentSet());
            updatedEmp.setTenant(employee.getTenant());
            employeeRepository.save(updatedEmp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Page<Employee> getEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getAllEmployee() {
   return employeeRepository.findAll();
    }
}
