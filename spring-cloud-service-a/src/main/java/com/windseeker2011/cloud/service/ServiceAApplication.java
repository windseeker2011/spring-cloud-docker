package com.windseeker2011.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class ServiceAApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceAApplication.class, args);
	}

}
