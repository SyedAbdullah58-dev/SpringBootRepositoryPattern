package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job{
    @Id
    @Column(name = "jobId", nullable = false)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobRequirements;
    private String jobLocation;
    private String jobSalary;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "companyId")
private Department department;
    @ManyToMany()
@JoinTable(
        name = "applied_Job"
        , joinColumns = @JoinColumn(name = "job_id")
        , inverseJoinColumns = @JoinColumn(name = "applicant_id")
)
private Set<Applicant> applicants=new HashSet<>();






    public Department getDepartment() {
        return department;
    }
    public Long getJobId() {
        return jobId;
    }
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
