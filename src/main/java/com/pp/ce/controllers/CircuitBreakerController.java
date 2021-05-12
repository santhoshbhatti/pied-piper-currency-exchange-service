package com.pp.ce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@GetMapping("/sample-api")
	//@Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name="default",fallbackMethod = "hardcodedResponse")
	public String sampleApi() {
		logger.info("executing the sample-api !!!!!!! >>>>>>>>>");
		String dummyResponse=new RestTemplate().getForObject("http://localhost:8080/dummy-url", String.class);
		return dummyResponse;
	}
	
	public String hardcodedResponse(Exception e) {
		//logger.error("error happened during call to sample-api. fallback invoked",e);
		return "harcoded response in case of failure of sample-api";
	}
}
