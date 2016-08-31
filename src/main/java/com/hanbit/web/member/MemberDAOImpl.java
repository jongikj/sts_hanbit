package com.hanbit.web.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :MemberDAO.java
 * @story  :
*/

@Repository
public class MemberDAOImpl implements MemberDAO{
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;
	private static final String NAMESPACE = "mapper.member.";
	private static MemberDAOImpl instance = new MemberDAOImpl();
	
	public static MemberDAOImpl getInstance() {
		if (instance == null){
			logger.info("MemberDAO Impl instance is created");
		}
		return instance;
	}
	
	private MemberDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch (IOException e){
			logger.info("session build fail");
		}
	}
	
	public MemberDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insert(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.insert(NAMESPACE + "insert", member);
		}finally {
			session.close();
		}
	}
	
	@Override
	public int update(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.update(NAMESPACE + "update", member);
		}finally {
			session.close();
		}
	}
	
	@Override
	public int delete(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.delete(NAMESPACE + "delete", member);
		}finally {
			session.close();
		}
	}
	//list
	@Override
	public List<MemberVO> list() {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList(NAMESPACE + "list");
		}finally {
			session.close();
		}
	}
	//findByPK
	@Override
	public MemberVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findById", id);
		} finally {
			session.close();
		}
	}
	//findByNotPK
	@Override
	public List<MemberVO> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList(NAMESPACE + "findByName", name);
		}finally {
			session.close();
		}
	}
	//count
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "count");
		}finally {
			session.close();
		}
	}
	
	@Override
	public boolean login(MemberVO param) {
		boolean loginOK = false;
		if (param.getId() != null && param.getPw() != null && this.existId(param.getId())) {
				MemberVO bean = this.findById(param.getId());
				if (bean.getPw().equals(param.getPw())) {
					loginOK = true;
			}
		}
		return loginOK;
	}

	@Override
	public boolean existId(String id){
		boolean flag = false;
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int temp = session.selectOne(NAMESPACE + "existId", id);
			if(temp == 1){
				flag = true;
			}
		} finally {
			session.close();
		}
		return flag;
	}
}