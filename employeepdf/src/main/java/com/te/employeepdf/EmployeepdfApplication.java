package com.te.employeepdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class EmployeepdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeepdfApplication.class, args);
	}

}
