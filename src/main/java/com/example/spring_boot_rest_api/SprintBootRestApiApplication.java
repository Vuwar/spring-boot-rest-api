package com.example.spring_boot_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SprintBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootRestApiApplication.class, args);
	}

}
