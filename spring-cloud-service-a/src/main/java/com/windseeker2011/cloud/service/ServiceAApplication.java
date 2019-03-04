package com.windseeker2011.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceAApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceAApplication.class, args);
	}

}
