package com.cognizant.spring_data_jpa_handson;

import com.cognizant.spring_data_jpa_handson.Entity.Employee;
import com.cognizant.spring_data_jpa_handson.Service.Employeeservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaHandsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaHandsonApplication.class, args);
	}
	@Bean
	CommandLineRunner run(Employeeservice employeeservice){
		return args->{
			Employee e1 = new Employee("Krish","CSE",21);
			Employee e2 = new Employee("Rahul","CSE",21);
			employeeservice.saveEmployee(e1);
			employeeservice.saveEmployee(e2);
			System.out.println("Employee saved successfully");

		};
	}
}
