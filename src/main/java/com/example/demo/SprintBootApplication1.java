package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SprintBootApplication1 extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SprintBootApplication1.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SprintBootApplication1.class, args);
	}

	/*
	 * @Override public void onStartup(ServletContext servletContext) throws
	 * ServletException { // 配置 Servlet servletContext.addServlet("servletTest",
	 * new ServletTest()).addMapping("/servletTest"); // 配置过滤器
	 * servletContext.addFilter("timeFilter", new TimFilter())
	 * .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true,
	 * "/*"); // 配置监听器 servletContext.addListener(new ListenerTest()); }
	 */

}
