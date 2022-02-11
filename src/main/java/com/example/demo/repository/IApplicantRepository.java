package com.example.demo.repository;

import com.example.demo.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApplicantRepository extends JpaRepository<Applicant,Long> {

}
