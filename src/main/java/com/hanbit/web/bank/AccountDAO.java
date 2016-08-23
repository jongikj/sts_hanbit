package com.hanbit.web.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


public class AccountDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	private static AccountDAO instance = new AccountDAO();
	
	private AccountDAO() {
		con = DatabaseFactory.createDatabase(
				Vendor.ORACLE, 
				Constants.USER_ID, 
				Constants.USER_PW).getConnection();
	}

	public static AccountDAO getInstance() {
		return instance;
	}

	public int insertAccount(AccountBean bean) {
		int result = 0;
		String sql = "insert into account (account_no, id, money) values (?, ?, ?)";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getAccountNo());
			pstmt.setString(2, bean.getId());
			pstmt.setInt(3, bean.getMoney());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void deposit(AccountBean bean) {
		String sql = "update account set money = ? where account_no = ?";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getMoney());
			pstmt.setInt(2, bean.getAccountNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void withdraw(AccountBean bean) {
		this.deposit(bean);
	}

	public int updateAccount(AccountBean bean) {
		int result = 0;
		String sql = "update member set pw = ? where id = ?";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getPw());
			pstmt.setString(2, bean.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteAccount(int accountNo) {
		int result = 0;
		String sql = "delete from account where account_no = ?";

		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<?> selectAll() {
		List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
		String sql = "select "
				+ "account_no as acc,"
				+ "id as id,"
				+ "name as name,"
				+ "money as money,"
				+ "ssn as birth"
				+ " from account_member"
				+ " order by name";
		
		try {
			pstmt = con.prepareStatement(sql);
 			rs = pstmt.executeQuery(); 
 			while (rs.next()){
 				AccountMemberBean bean = new AccountMemberBean();
 				bean.setAccountNo(rs.getInt("ACC"));
 				bean.setId(rs.getString("ID"));
 				bean.setName(rs.getString("NAME"));
 				bean.setMoney(rs.getInt("MONEY"));
 				bean.setBirth(rs.getString("BIRTH").substring(0, 6));	//0 이상 6 미만의 인덱스를 뽑아낸다
 				list.add(bean);
 			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public AccountBean findByAccountNo(int searchAcc) {
		AccountBean bean = null;
		String sql = "select * from account_member where account_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, searchAcc);
			rs = pstmt.executeQuery();

			if (rs.next()){
				bean = new AccountBean(
						rs.getInt("ACCOUNT_NO"),
						rs.getInt("MONEY"),
						rs.getString("ID"),
						rs.getString("PW"),
						rs.getString("NAME"),
						rs.getString("REG_DATE"),
						rs.getString("SSN"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	public List<?> findByName(String name) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		String sql = "select * from account_member where name = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccountBean bean = new AccountBean();
				bean.setAccountNo(rs.getInt("ACCOUNT_NO"));
				bean.setMoney(rs.getInt("MONEY"));
				bean.setId(rs.getString("ID"));
				bean.setPw(rs.getString("PW"));
				bean.setName(rs.getString("NAME"));
				bean.setRegDate(rs.getString("REG_DATE"));
				bean.setSsn(rs.getString("SSN"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int count() {
		int result = 0;
		String sql = "select count(*) as count from account_member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getInt("count");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int selectMoney(int accountNo) {
		int money = 0;
		String sql = "select money from account where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				money = rs.getInt("MONEY");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}

	public Map<?, ?> selectMap() {
		Map<String, AccountMemberBean> map = new HashMap<String, AccountMemberBean>();
		String sql = "select * from account_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AccountMemberBean bean = new AccountMemberBean();
				bean.setAccountNo(rs.getInt("ACCOUNT_NO"));
				bean.setId(rs.getString("ID"));
				bean.setMoney(rs.getInt("MONEY"));
				bean.setName(rs.getString("NAME"));
				bean.setPw(rs.getString("PW"));
				bean.setRegDate(rs.getString("REG_DATE"));
				bean.setSsn(rs.getString("SSN"));
				map.put(String.valueOf(bean.getAccountNo()), bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}