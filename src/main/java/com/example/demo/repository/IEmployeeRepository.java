package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long>
{
@Procedure("getRecordCount")
public String getTotalEmployee();

  @Async
CompletableFuture<List<Employee>> findByDesignation(String designation);


  /*  @Async
    @Query(value = "select * from employee where designation = ?1",nativeQuery = true)
    List<Employee> findByDesignationAsync(String designation);*/

}
