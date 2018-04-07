package com.example.demo.websocketinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebScoketController {

	@RequestMapping("/index")
	public String OnScoketNo1() {
		System.out.println("jinru index");
		return "index";
	}
}
