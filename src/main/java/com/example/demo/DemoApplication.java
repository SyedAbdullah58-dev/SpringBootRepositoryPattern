package com.example.demo;


import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
@EnableAsync
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}
	@Bean
	public void dataFaker() {
		Faker faker=new Faker();
		System.out.println(faker.name().firstName());
		System.out.println(faker.name().lastName());
		System.out.println(faker.name().fullName());

	}




	}

