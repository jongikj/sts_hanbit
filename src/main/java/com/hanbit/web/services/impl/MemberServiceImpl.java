package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.GradeMapper;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :StudentServiceImpl.java
 * @story  :
*/

@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired private SqlSession sqlSession;

	public String regist(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String msg = "";
		MemberDTO temp = this.findById(mem.getId());
		if (temp == null) {
			System.out.println(mem.getId()+"가 존재하지 않음,가입 가능한 ID");
			int result = mapper.insert(mem);
			if (result==1) {
				msg = "success";
			} else {
				msg = "fail";
			}
		} else {
			System.out.println(mem.getId()+"가 존재함,가입 불가능한 ID");
			msg = "fail";
		}
		return msg;
	}

	public void update(MemberDTO bean) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	}

	public void delete(MemberDTO bean) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	}
	
	public int count(){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return 0;
	}

	public MemberDTO findById(String findID) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findById(findID);
	}

	public List<MemberDTO> list() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}

	public List<MemberDTO> findByName(String findName) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}

	public List<?> findBy(String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}

	public Map<?, ?> map() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	
	public boolean existId(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return false;
	}

	public MemberDTO findBy() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	
	public void logout(MemberDTO bean){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		logger.info("MemberService login =  {}", member.getId());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		MemberDTO mem = mapper.findById(member.getId());
		if(mem.getPw().equals(member.getPw())){
			logger.info("MemberService LOGIN IS {} ", "SUCCESS");
			return mem;
		}
		logger.info("MemberService LOGIN IS {} ", "FAIL");
		mem.setId("NONE");
		return mem;
	}
}