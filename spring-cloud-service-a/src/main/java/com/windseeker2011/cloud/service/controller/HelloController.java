package com.windseeker2011.cloud.service.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(value = "/timeout")
	public String timeout(@RequestParam long m) {
		return helloService.timeout(m);
	}

	@GetMapping(value = "/haha")
	public String haha(HttpServletRequest request) {
		
		return "haha : " + request.getServerPort();
	}

}
