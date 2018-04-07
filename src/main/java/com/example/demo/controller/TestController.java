package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello")
	public String getHello() {

		return "Hello Wrold";
	}

	@GetMapping("/hello2")
	public String getHello2() {
		return "Hello World I have love you";
	}

}
