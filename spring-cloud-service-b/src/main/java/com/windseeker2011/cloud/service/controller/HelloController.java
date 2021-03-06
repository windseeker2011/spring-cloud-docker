package com.windseeker2011.cloud.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@GetMapping(value = "/hello")
	public String hello() {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		return ops.get("hello");
	}

	@GetMapping(value = "/timeout")
	public String timeout(@RequestParam long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(m);
	}

}
