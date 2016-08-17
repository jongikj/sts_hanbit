package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.global.Constants;
import com.hanbit.web.global.DatabaseFactory;
import com.hanbit.web.global.Vendor;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :GradeDAO.java
 * @story  :
*/
public class GradeDAO {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	private static GradeDAO instance = new GradeDAO();

	public static GradeDAO getInstance() {
		return instance;
	}

	private GradeDAO() {
		con = DatabaseFactory.createDatabase(
				Vendor.ORACLE, 
				Constants.USER_ID, 
				Constants.USER_PW).getConnection();
	}
	
	public int insert(GradeBean bean){
		int result = 0;
		String sql = "insert into grade(seq, grade, java, sql, html, javascript, id, exam_date) "
				+ "values(seq.nextval, ?, ?, ?, ?, ?, ?, ?)"; //첫번째 물음표 인덱스는 1번임 0이 아니라
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getGrade());
			pstmt.setInt(2, bean.getJava());
			pstmt.setInt(3, bean.getSql());
			pstmt.setInt(4, bean.getHtml());
			pstmt.setInt(5, bean.getJavascript());
			pstmt.setString(6, bean.getId());
			pstmt.setString(7, bean.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(String seq, String sub, GradeBean bean) {
		int result = 0;
		String sql = "update grade set java = ?, sql = ?, html = ?, javascript = ? where seq = ?";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, findBySeq(seq).getJava());
			pstmt.setInt(2, findBySeq(seq).getSql());
			pstmt.setInt(3, findBySeq(seq).getHtml());
			pstmt.setInt(4, findBySeq(seq).getJavascript());
			pstmt.setString(5, findBySeq(seq).getGrade());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String seq){
		int result = 0;
		String sql = "delete from grade where seq = ?";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	
	public List<?> list(){
		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "select * from grade";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				GradeBean bean = new GradeBean();
				bean.setSeq(String.valueOf(rs.getInt("SEQ")));
				bean.setId(rs.getString("ID"));
				bean.setExamDate(rs.getString("EXAM_DATE"));
				bean.setGrade(rs.getString("GRADE"), 
						rs.getInt("JAVA"),
						rs.getInt("SQL"),
						rs.getInt("HTML"),
						rs.getInt("JAVASCRIPT"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public GradeBean findBySeq(String seq){
		GradeBean bean = null;
		String sql = "select * from grade where seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(seq));
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new GradeBean(
						rs.getString("SEQ"),
						rs.getString("GRADE"),
						rs.getInt("JAVA"),
						rs.getInt("SQL"),
						rs.getInt("HTML"),
						rs.getInt("JAVASCRIPT"),
						rs.getString("ID"),
						rs.getString("EXAM_DATE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	public List<?> findById(String id){
		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "select * from grade where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				GradeBean bean = new GradeBean(
						rs.getString("SEQ"),
						rs.getString("GRADE"),
						rs.getInt("JAVA"),
						rs.getInt("SQL"),
						rs.getInt("HTML"),
						rs.getInt("JAVASCRIPT"),
						rs.getString("ID"),
						rs.getString("EXAM_DATE"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int count(String examDate) {
		int result = 0;
		String sql = "select count(*) as count from grade where exam_date = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, examDate);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int count() {
		return 0;
	}
}