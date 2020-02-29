package com.transport.config;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author dward
 *
 * JNDI Configuration: (Localhost Server files for development)
 * 
 * 	server.xml - Resource in GlobalNamingResources
 *  context.xml - ResourceLink (Server Level) 
 *  
 *  Note: ResourceLink can do in context.xml under META-INF folder for Application Level 
 */

public class ServerContext {

	private static DataSource datasource;

	static {
		try {
			Context initialContext = new InitialContext();	
			datasource = (DataSource) initialContext.lookup("java:comp/env/jdbc/transport");	
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJDBCHandle() throws Exception {
		return datasource.getConnection();
	}
}
