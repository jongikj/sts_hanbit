package com.hanbit.web.bank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


public class AccountDAOImpl implements AccountDAO {
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;
	private static final String NAMESPACE = "mapper.account.";
	private static AccountDAOImpl instance = new AccountDAOImpl();
	
	private AccountDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch (IOException e){
			logger.info("session build fail");
		}	
	}
	
	public AccountDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public static AccountDAOImpl getInstance() {
		if (instance == null){
			logger.info("AccountDAO Impl instance is created");
		}
		return instance;
	}

	public int insertAccount(AccountVO account) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.insert(NAMESPACE + "insertAccount", account);
		}finally {
			session.close();
		}
	}

	public int deposit(AccountVO account) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.update(NAMESPACE + "deposit", account);
		}finally {
			session.close();
		}
	}
	
	public void withdraw(AccountVO account) {
		this.deposit(account);
	}

	public int updateAccount(AccountVO account) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.update(NAMESPACE + "updateAccount", account);
		}finally {
			session.close();
		}
	}
	
	public int deleteAccount(int accountNo) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.delete(NAMESPACE + "deleteAccount", accountNo);
		}finally {
			session.close();
		}
	}

	public List<?> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList(NAMESPACE + "selectAll");
		}finally {
			session.close();
		}
	}
	
	public AccountVO findByAccountNo(int searchAcc) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findByAccountNo", searchAcc);
		} finally {
			session.close();
		}
	}

	public List<?> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList(NAMESPACE + "findByName", name);
		}finally {
			session.close();
		}
	}

	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "count");
		}finally {
			session.close();
		}
	}

	public int selectMoney(int accountNo) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "selectMoney", accountNo);
		}finally {
			session.close();
		}
	}

	public Map<?, ?> selectMap() {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectMap("", "");
		}finally {
			session.close();
		}
	}
}