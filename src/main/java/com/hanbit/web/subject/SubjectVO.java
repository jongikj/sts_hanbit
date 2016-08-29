package com.hanbit.web.subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hanbit.web.util.Constants;

/**
 * @date   :2016. 7. 26.
 * @author :장종익
 * @file   :SubjectDAO.java
 * @story  :
*/
public class SubjectVO {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	private static SubjectVO instance = new SubjectVO();
	
	private SubjectVO() {
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL, 
					Constants.USER_ID, 
					Constants.USER_PW);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SubjectVO getInstance() {
		return instance;
	}
	
	public void insert(SubjectBean sub){
		int result = 0;
		String sql = "insert into subject(subj_seq,major,subjects,id)"
				+ " values(subj_seq.nextval,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sub.getMajor());
			pstmt.setString(2, sub.getSubjects());
			pstmt.setString(3, sub.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println("과목 추가 성공");
		} else {
			System.out.println("과목 추가 실패");
		}
	}
	
	public SubjectBean findById(String id){
		SubjectBean s = null;
		String sql = "select "
				+ "id as id, "
				+ "major as major, "
				+ "subjects as sub "
				+ "from subject where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				s = new SubjectBean();
				s.setId(rs.getString("id"));
				s.setMajor(rs.getString("major"));
				s.setSubjects(rs.getString("sub"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
