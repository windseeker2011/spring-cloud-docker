package com.windseeker2011.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b")
public interface HelloService {

	@GetMapping(value = "/hello")
	public String hello();
}
