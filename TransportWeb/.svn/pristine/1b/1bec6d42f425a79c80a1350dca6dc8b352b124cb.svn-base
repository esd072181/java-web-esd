package com.transport.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConfig {
	
	private static ClassPathXmlApplicationContext ctx = null;

	public static ClassPathXmlApplicationContext getSpringXMLConfig() {
		if (ctx==null) {
			ctx = new ClassPathXmlApplicationContext("Spring.xml");
			ctx.registerShutdownHook();
		}
		if (!ctx.isActive()) {
			 refreshSpringConfig(ctx); //need to refresh the context after close()
		}
		return ctx;
	}
	
	public static void closeSpringConfig() {
		if (ctx!=null) {
			ctx.close(); //Spring IOC container will become inactive	
		}
	}
	
	private static void refreshSpringConfig(ClassPathXmlApplicationContext ctx) {
		ctx.refresh();
	}
	
}
