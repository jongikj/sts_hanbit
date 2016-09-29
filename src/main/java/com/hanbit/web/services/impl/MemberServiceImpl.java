package com.hanbit.web.services.impl;

import java.util.ArrayList;
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
import com.hanbit.web.domains.Retval;
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
	@Autowired private Retval retval;
	@Autowired Command command;
	
	public String regist(MemberDTO mem) {
		return (sqlSession.getMapper(MemberMapper.class).insert(mem)==1) ? "success" : "fail";
	}

	public String update(MemberDTO bean) {
		return (sqlSession.getMapper(MemberMapper.class).update(bean) == 1) ? "success" : "fail";
	}

	public void delete(MemberDTO bean) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	}
	
	public Retval count(){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}

//	public MemberDTO findOne(Command command) {
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		return mapper.findOne(command); 
//	}

	public List<MemberDTO> findByName(String findName) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list(command);
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

	public List<?> find(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.find(command);
	}
	
	public void logout(MemberDTO bean){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MemberDTO login(MemberDTO member) {
		logger.info("MemberService login =  {}", member.toString());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Command command = new Command();
		command.setKeyword(member.getId());
		command.setKeyField("mem_id");
		list = (List<MemberDTO>) mapper.find(command);
		String pw = list.get(0).getPw();
		if(pw.equals(member.getPw())){
			logger.info("MemberService LOGIN IS {} ", "SUCCESS");
			return list.get(0);
		} else {
			logger.info("MemberService LOGIN IS {} ", "FAIL");
			return list.get(0);
		}
	}

	public List<?> list(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list(command);
	}
}