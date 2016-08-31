package com.hanbit.web.subject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;

/**
 * @date   :2016. 7. 26.
 * @author :장종익
 * @file   :SubjectDAO.java
 * @story  :
*/
@Repository
public class SubjectDAOImpl implements SubjectDAO{
	private static final Logger logger = LoggerFactory.getLogger(SubjectDAOImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;
	private static final String NAMESPACE = "mapper.subject.";
	private static SubjectDAOImpl instance = new SubjectDAOImpl();
	
	private SubjectDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch (IOException e){
			logger.info("session build fail");
		}
	}

	public static SubjectDAOImpl getInstance() {
		if (instance == null){
			logger.info("SubjectDAO Impl instance is created");
		}
		return instance;
	}
	
	public SubjectDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public int insert(SubjectVO sub){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.insert(NAMESPACE + "insert", sub);
		}finally {
			session.close();
		}
	}
	
	public SubjectVO findById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findById", id);
		}finally {
			session.close();
		}
	}
}
