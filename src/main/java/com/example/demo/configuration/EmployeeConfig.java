package com.example.demo.configuration;

import com.example.demo.filter.EmployeeFilter;
import com.example.demo.repository.IEmployeeRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig{

    @Bean
    public FilterRegistrationBean<EmployeeFilter> loggingFilter(){
        FilterRegistrationBean<EmployeeFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new EmployeeFilter());
        registrationBean.addUrlPatterns("/api/v1/employee");
        registrationBean.setOrder(2);
        registrationBean.setName("Employee Filter");
        return registrationBean;

    }}
/*

    public EmployeeConfig(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
*/
/*
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            Employee employee= new Employee(23000,"Manager","Syed","Abdullah","Rawalpindi","0334135145","syedab@gmail.com");
            Employee employee1= new Employee(23000,"Employee","Kashif","Khan","Rawalpindi","0334135145","Kashif@gmail.com");
        employeeRepository.saveAll(
                List.of(employee1,employee)
        );

        };
    }*/