package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.User;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@RequestMapping("/hello")
	public String hello(Map<String, Object> map) {
		map.put("msg", "Hello Thymeleaf");
		return "hello";
	}

	@RequestMapping("/getUserInfo")
	@ResponseBody
	public User user() {
		User user = new User();
		// user.setUserid("1");
		// user.setUsername("xiaowang");
		// user.setUserpwd("xiaowang");
		// user.setCreateDate(new Date());
		return user;
	}
}
