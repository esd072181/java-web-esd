package com.pibs.config;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class SpringContext {
	
	private static DataSource dataSource;
	private static JdbcTemplate jdbcTemplate;
    
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	public static JdbcTemplate getJDBCHandle() {
		if (jdbcTemplate==null) {
			 jdbcTemplate = new JdbcTemplate(dataSource);
		}
		 return jdbcTemplate;
	}

	
}
