package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<Job, Long> {

}
