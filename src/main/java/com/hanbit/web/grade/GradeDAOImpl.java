package com.hanbit.web.grade;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :GradeDAO.java
 * @story  :
*/
public class GradeDAOImpl implements GradeDAO{
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;
	private static final String NAMESPACE = "mapper.grade.";
	private static GradeDAOImpl instance = new GradeDAOImpl();

	public static GradeDAOImpl getInstance() {
		if (instance == null){
			logger.info("GradeDAO Impl instance is created");
		}
		return instance;
	}

	private GradeDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch (IOException e){
			logger.info("session build fail");
		}
	}
	
	public GradeDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public int insert(GradeVO grade){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.insert(NAMESPACE + "insert", grade);
		}finally {
			session.close();
		}
	}

	public int update(String seq, String sub, GradeVO grade) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.update(NAMESPACE + "update", grade);
		}finally {
			session.close();
		}
	}
	
	public int delete(String seq){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.delete(NAMESPACE + "delete", seq);
		}finally {
			session.close();
		}
	}	
	
	public List<?> list(){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList(NAMESPACE + "list");
		}finally {
			session.close();
		}
	}
	
	public GradeVO findBySeq(String seq){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findBySeq", seq);
		}finally {
			session.close();
		}
	}
	
	public GradeVO findById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findById", id);
		}finally {
			session.close();
		}
	}

	public int count(String examDate) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "examDate");
		}finally {
			session.close();
		}
	}

}