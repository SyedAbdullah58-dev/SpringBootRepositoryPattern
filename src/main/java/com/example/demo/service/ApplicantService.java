package com.example.demo.service;

import com.example.demo.model.Applicant;
import com.example.demo.repository.IApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

private final IApplicantRepository applicantRepository;
@Autowired
    public ApplicantService(IApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<Applicant> getApplicant() {
   return applicantRepository.findAll();

    }

    public Applicant addApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public Applicant updateApplicant(int id, Applicant applicant) {
        Applicant applicant1 = applicantRepository.findById(Long.valueOf(id)).get();
        applicant1.setFirstName(applicant.getFirstName());
        applicant1.setLastName(applicant.getLastName());
        applicant1.setEmail(applicant.getEmail());
        applicant1.setPhone(applicant.getPhone());
        applicant1.setAddress(applicant.getAddress());
        applicant1.setCity(applicant.getCity());
        applicant1.setState(applicant.getState());
        applicant1.setZip(applicant.getZip());
        applicant1.setCountry(applicant.getCountry());
        applicant1.setDob(applicant.getDob());
        return applicantRepository.save(applicant1);
    }

    public Optional<Applicant> getApplicant(int id) {
        return applicantRepository.findById(Long.valueOf(id));
    }

    public void deleteApplicant(int id) {
        applicantRepository.deleteById(Long.valueOf(id));
    }
}
