package com.sam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {

	@Autowired
	RestTemplate rest;
	
	@HystrixCommand(fallbackMethod = "defaultInfo")
	public String getInfo()
	{
		ResponseEntity<String> response = 
				rest.getForEntity("http://localhost:8090/info", String.class);
		return response.getBody();
	}
	
	public String defaultInfo()
	{
		return "This is default Info";
	}
}
