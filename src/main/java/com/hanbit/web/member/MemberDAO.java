package com.hanbit.web.member;

import java.util.List;

public interface MemberDAO {
	public int insert(MemberVO member);
	public int update(MemberVO member);
	public int delete(MemberVO member);
	public List<MemberVO> list();
	public MemberVO findById(String id);
	public List<MemberVO> findByName(String name);
	public int count();
	public boolean login(MemberVO param);
	public boolean existId(String id);
}
