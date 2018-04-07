package com.example.demo.life;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

@Component
public class ListenerTest implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("监听器初始化...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Destroyed .... ");
	}

}