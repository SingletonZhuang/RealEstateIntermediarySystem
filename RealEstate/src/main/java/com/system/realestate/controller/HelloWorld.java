package com.system.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorld {
	
	@RequestMapping("/index")
	public String index() {
		return "/webpage/hello.html";
	}
}
