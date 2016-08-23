package com.hanbit.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :MemberDAO.java
 * @story  :
*/

public class MemberDAO {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;	//executeQuery() 에서만 리턴받는 객체
	private static MemberDAO instance = new MemberDAO();	// 2.private static형 DAO로 생성한다. 이름은 instance
	
	public static MemberDAO getInstance() {	// 3. instnace의 getter만 만들어준다.
		return instance;
	}

	private MemberDAO() { // 1. private 생성자를 만든다
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
	
	public int insert(MemberBean bean){
		int result = 0;
		String sql = "insert into member(id, pw, name, reg_date, ssn, email, profile_img, phone)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getRegDate());
			pstmt.setString(5, bean.getSsn());
			pstmt.setString(6, bean.getEmail());
			pstmt.setString(7, "default.png");
			pstmt.setString(8, bean.getPhone());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1){
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return result;
	}
	
	public int update(MemberBean bean){
		int result = 0;
		String sql = "update member set pw = ?, email = ? where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getPw());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result == 1){
			System.out.println("DAO에서 수정 성공");
		} else {
			System.out.println("DAO에서 수정 실패");
		}
		return result;
	}
	
	public int delete(MemberBean bean){
		int result = 0;
		String sql = "delete from member where id = ? and pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result == 1){
			System.out.println("DAO에서 삭제 성공");
		} else {
			System.out.println("DAO에서 삭제 실패");
		}
		return result;
	}
	
	public int exeUpdate(String sql) {
		int updateResult = 0;
		
		try {
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(updateResult == 1){
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return updateResult;
	}
	
	//list
	public List<MemberBean> list() {
		String sql = "select * from member";
		List<MemberBean> list = new ArrayList<MemberBean>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberBean tempBean = new MemberBean();
				tempBean.setId(rs.getString("ID"));
				tempBean.setPw(rs.getString("PW"));
				tempBean.setName(rs.getString("NAME"));
				tempBean.setEmail(rs.getString("EMAIL"));
//				tempBean.setGenderAndBirth(rs.getString("SSN"));
				tempBean.setPhone(rs.getString("PHONE"));
				tempBean.setRegDate(rs.getString("REG_DATE"));
				tempBean.setProfileImg(rs.getString("PROFILE_IMG"));
				list.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//findByPK
	public MemberBean findById(String id) {
		String sql = "select * from member where id = ?";
		MemberBean temp = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				temp = new MemberBean();
				temp.setId(rs.getString("ID"));
				temp.setPw(rs.getString("PW"));
				temp.setName(rs.getString("NAME"));
				temp.setRegDate(rs.getString("REG_DATE"));
				temp.setSsn(rs.getString("SSN"));
				temp.setGenderAndBirth(rs.getString("SSN"));
				temp.setEmail(rs.getString("EMAIL"));
				temp.setProfileImg(rs.getString("PROFILE_IMG"));
				temp.setPhone(rs.getString("PHONE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	//findByNotPK
	public List<MemberBean> findByName(String name) {
		String sql = "select * from member where name = ?";
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemberBean temp = new MemberBean();
				temp.setId(rs.getString("ID"));
				temp.setPw(rs.getString("PW"));
				temp.setName(rs.getString("NAME"));
				temp.setRegDate(rs.getString("REG_DATE"));
				temp.setSsn(rs.getString("SSN"));
				temp.setGenderAndBirth(rs.getString("SSN"));
				temp.setEmail(rs.getString("EMAIL"));
				temp.setProfileImg(rs.getString("PROFILE_IMG"));
				temp.setPhone(rs.getString("PHONE"));
				list.add(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//count
	public int count() {
		String sql = "select count(*) as count from member";
		int count = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public boolean login(MemberBean param) {
		boolean loginOK = false;
		if(param.getId() != null && param.getPw() != null && this.existId(param.getId())){
			MemberBean bean = this.findById(param.getId());
			if (bean.getPw().equals(param.getPw())){
				loginOK = true;
			}
		}
		return loginOK;
	}
	
	public boolean existId(String id){
		boolean existOK = false;
		int result = 0;
		String sql = "select count(*) as count from member where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result  = rs.getInt("count");
				System.out.println("ID 카운트 결과 : " + result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1){
			existOK = true;
		}
		return existOK;
	}
}