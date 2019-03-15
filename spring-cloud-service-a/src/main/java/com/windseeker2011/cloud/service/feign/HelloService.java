package com.windseeker2011.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.windseeker2011.cloud.service.feign.fallback.HelloServiceImpl;

@FeignClient(name = "service-b", fallback = HelloServiceImpl.class)
public interface HelloService {

	@GetMapping(value = "/hello")
	public String hello();

	@GetMapping(value = "/timeout")
	public String timeout(@RequestParam long m);
}
