package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :StudentServiceImpl.java
 * @story  :
*/

@Service
@Qualifier("memberService")
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	@Autowired private MemberDTO member;
	@Autowired Command command;
	
	public String regist(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String msg = "";
		int result = mapper.insert(member);
		return (sqlSession.getMapper(MemberMapper.class).insert(member)==1) ? "success" : "fail";
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

	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command); 
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
	
	@Override
	public int existId(String id) {
		logger.info("MemberService existId ID is {}", id);
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.existId(id);
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
		logger.info("MemberService login =  {}", member.toString());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Command command = new Command();
		command.setKeyword(member.getId());
		command.setOption("mem_id");
		MemberDTO mem = mapper.findOne(command);
		if(mem.getPw().equals(member.getPw())){
			logger.info("MemberService LOGIN IS {} ", "SUCCESS");
			return mem;
		} else {
			logger.info("MemberService LOGIN IS {} ", "FAIL");
			mem.setId("NONE");
			return mem;
		}
	}
}