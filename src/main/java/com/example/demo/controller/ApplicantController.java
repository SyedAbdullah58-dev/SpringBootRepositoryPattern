package com.example.demo.controller;

import com.example.demo.model.Applicant;
import com.example.demo.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/applicant")
public class ApplicantController {
  private final ApplicantService applicantService;
@Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    @GetMapping()
    public List<Applicant> getApplicant() {
        return applicantService.getApplicant();
    }
    @PostMapping()
    public Applicant addApplicant(@RequestBody Applicant applicant) {
        return applicantService.addApplicant(applicant);
    }
    @GetMapping(path = "/{id}")
    public Optional<Applicant> getApplicant(@PathVariable("id") int id) {
        return applicantService.getApplicant(id);
    }
    @PutMapping(path = "/{id}")
    public Applicant updateApplicant(@PathVariable("id") int id, @RequestBody Applicant applicant) {
        return applicantService.updateApplicant(id, applicant);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteApplicant(@PathVariable("id") int id) {
        applicantService.deleteApplicant(id);
    }
}
