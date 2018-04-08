package org.acasado.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
	//volatile is thread safe
	private static volatile DbSingleton instance = null;
	private static volatile Connection conn = null;
	
	private DbSingleton() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(conn != null) {
			throw new RuntimeException("Use getConnection() method to create");
		}

		if(instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
		if(conn != null) {
			throw new RuntimeException("Use getConnection() method to create");
		}
		
		if(instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}
	
	public static DbSingleton getInstance() {
		if(instance == null) {
			//protect from running by reflection
			//No threads
			synchronized(DbSingleton.class) {
				if(instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
		if(conn == null) {
			synchronized (DbSingleton.class) {
				if(conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						conn = DriverManager.getConnection(dbUrl);

//						conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
//										"user=root&password=root");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
}
