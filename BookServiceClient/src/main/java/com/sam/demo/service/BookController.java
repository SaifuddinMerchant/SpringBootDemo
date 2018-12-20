package com.sam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
public class BookController {

	@Autowired
	BookService service;

	@HystrixCommand(fallbackMethod = "defaultInfo")
	@RequestMapping(value = "/getinfo", method = RequestMethod.GET)
	public String getInfo() {
		return service.getInfo();

	}
	public String defaultInfo()
	{
		return "This is default Info";
	}
}
