package com.windseeker2011.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Spring Cloud Zuul
 * 
 * @author Weihai Li
 *
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

}
