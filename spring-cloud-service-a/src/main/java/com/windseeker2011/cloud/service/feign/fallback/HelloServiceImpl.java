package com.windseeker2011.cloud.service.feign.fallback;

import org.springframework.stereotype.Service;

import com.windseeker2011.cloud.service.feign.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello() {
		return "[service a] hello";
	}

}
