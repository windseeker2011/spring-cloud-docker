package com.windseeker2011.cloud.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.windseeker2011.cloud.service.feign.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping(value = "/hello")
	public String hello() {
		return helloService.hello();
	}

	@GetMapping(value = "/haha")
	public String haha() {
		return "haha";
	}

}
