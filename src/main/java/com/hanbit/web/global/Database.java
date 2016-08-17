package com.hanbit.web.global;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :Database.java
 * @story  :
*/
public class Database {
	private Connection con;
	private String driver, url, id, pw;
	
	public Database(String driver, String url, String id, String pw) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}