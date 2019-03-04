package com.windseeker2011.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceBApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceBApplication.class, args);
	}

}
