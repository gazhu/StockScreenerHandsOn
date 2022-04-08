package com.ey.wamacademy.capstoneapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.ey.wamacademy.capstoneapi.controller", "com.ey.wamacademy.capstoneapi.services",
		"com.ey.wamacademy.capstoneapi.dao" })
public class CapstoneApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApiApplication.class, args);
	}

}
