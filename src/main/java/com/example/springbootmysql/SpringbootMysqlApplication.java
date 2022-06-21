package com.example.springbootmysql;

import com.example.springbootmysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMysqlApplication.class, args);
	}
}

