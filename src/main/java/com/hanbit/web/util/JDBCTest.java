package com.hanbit.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.constants.Values;

/**
 * @date   :2016. 6. 30.
 * @author :장종익
 * @file   :JDBCTest.java
 * @story  :
*/
public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select name from member where mem_id = 'prof_james'", result = "";
		List<String> list  = new ArrayList<String>();
		try {
			Class.forName(Values.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Values.ORACLE_URL,
					Values.USER_ID,
					Values.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				result = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}
}