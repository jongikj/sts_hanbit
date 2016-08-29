package com.hanbit.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.util.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :MemberDAO.java
 * @story  :
*/

@Repository
public class MemberDAOImpl implements MemberDAO{
	private SqlSessionFactory sqlSessionFactory = null;
	
	public MemberDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insert(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("", member);
	}
	
	@Override
	public int update(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("", member);
	}
	
	@Override
	public int delete(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("", member);
	}
	
	//list
	@Override
	public List<MemberVO> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	
	//findByPK
	@Override
	public MemberVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("", id);
	}
	
	//findByNotPK
	@Override
	public List<MemberVO> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("", name);
	}
	
	//count
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
	
	@Override
	public boolean login(MemberVO param) {
		boolean loginOK = false;
		if(param.getId() != null && param.getPw() != null && this.existId(param.getId())){
			MemberVO bean = this.findById(param.getId());
			if (bean.getPw().equals(param.getPw())){
				loginOK = true;
			}
		}
		return loginOK;
	}
	
	@Override
	public boolean existId(String id){
		SqlSession session = sqlSessionFactory.openSession();
		int temp = session.selectOne("", id);
		return false;
	}
}