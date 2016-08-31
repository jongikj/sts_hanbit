package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :StudentServiceImpl.java
 * @story  :
*/

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired private MemberVO member;	
	@Autowired private SubjectVO sb;
	@Autowired private SubjectMemberVO sm;
	@Autowired private AccountServiceImpl accService;
	private MemberDAOImpl dao;
	private SubjectDAOImpl subjDao;
	
	public MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		subjDao = SubjectDAOImpl.getInstance();
	}
	
	@Override
	public String regist(MemberVO bean) {
		String msg = "";
		MemberVO temp = this.findById(bean.getId());
		if (temp == null) {
			System.out.println(bean.getId() + "가 존재하지 않음, 가입 가능한 ID");
			int result = dao.insert(bean);
			if (result == 1) {
				msg = "success";
			} else {
				msg = "fail";
			}
		} else {
			System.out.println(bean.getId() + "가 존재함, 가입 불가능한 ID");
			msg = "fail";
		}
		return msg;
	}

	@Override
	public void update(MemberVO bean) {
		int result = dao.update(bean);
		if (result == 1) {
			System.out.println("서비스 수정 결과 성공");
		} else {
			System.out.println("서비스 수정 결과 실패");
		}
	}

	@Override
	public void delete(MemberVO bean) {
		dao.delete(bean);
	}
	
	public int count(){
		return dao.count();
	}

	@Override
	public MemberVO findById(String findID) {
		return dao.findById(findID);
	}

	@Override
	public List<MemberVO> list() {
		return dao.list();
	}

	@Override
	public List<MemberVO> findByName(String findName) {
		return dao.findByName(findName);
	}

	@Override
	public List<?> findBy(String keyword) {
		// TODO Auto-generated method stub
		return dao.findByName(keyword);
	}

	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SubjectMemberVO login(MemberVO bean) {
		if (dao.login(bean)) {
			member = dao.findById(bean.getId());
			System.out.println("서비스 로그인 하는중 ... ID : " + member.getId());
//			accService.map();
			sb = subjDao.findById(bean.getId());
			sm.setEmail(member.getEmail());
			sm.setId(member.getId());
			sm.setImg(member.getProfileImg());
     		sm.setMajor(sb.getMajor()); 
			sm.setName(member.getName());
			sm.setPhone(member.getPhone());
			sm.setPw(member.getPw());
			sm.setReg(member.getRegDate());
			sm.setSsn(member.getSsn());
			sm.setSubjects(sb.getSubjects()); 
		} else {
			sm.setId("fail");
		}
		System.out.println("서비스 로그인 결과 : " + sm.getId());
		return sm;
	}

	@Override
	public boolean existId(String id) {
		return dao.existId(id);
	}

	@Override
	public MemberVO findBy() {
		return member;
	}
	
	public void logout(MemberVO bean){
		if(bean.getId().equals(member.getId()) && bean.getPw().equals(member.getPw())){
			this.member = null;
		}
	}
}