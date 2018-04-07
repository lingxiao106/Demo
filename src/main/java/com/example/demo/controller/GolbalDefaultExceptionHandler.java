package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GolbalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> defaultExceptionHandler(Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 500);
		map.put("msg", e.getMessage());
		return map;
	}
}
