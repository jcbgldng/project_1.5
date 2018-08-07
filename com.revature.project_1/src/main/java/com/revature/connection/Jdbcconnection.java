package com.revature.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Jdbcconnection {
	
	private Jdbcconnection() {}
	
	public static Connection getConnection() {
		InputStream in = null;
		
		try {
			Properties props = new Properties();
			in = new FileInputStream("/Users/jacobgolding/Desktop/revature/project/project_1/com.revature.project_1/src/main/resources/connection.properties");
			props.load(in);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = null;
			String endpoint = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			
			conn = DriverManager.getConnection(endpoint, username, password);
			return conn;
		} 
		catch (Exception e) {
			log(e);
		}finally {
			try {
				in.close();
			} catch (Exception e2) {
				log(e2);
			}
		}
		return null;
	}
	public static void log(Throwable e) {
        final Logger log = Logger.getLogger(Jdbcconnection.class);
        log.error(e);
    }

}
