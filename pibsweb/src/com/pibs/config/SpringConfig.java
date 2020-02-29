package com.pibs.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConfig {
	
	private static final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");

	public static ClassPathXmlApplicationContext getSpringXMLConfig() {
		return ctx;
	}
	
	public static void closeSpringConfig() {
		ctx.close();
	}
	
}
