package com.fincons.academy.travelclientspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("/**")
@ComponentScan("com.fincons.academy.travelclientspringboot")
public class TravelClientSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelClientSpringbootApplication.class, args);
	}

}
