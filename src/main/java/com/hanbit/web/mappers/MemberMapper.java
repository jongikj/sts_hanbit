package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.MemberDTO;

public interface MemberMapper {
	public int insert(MemberDTO member);
	public int update(MemberDTO member);
	public int delete(MemberDTO member);
	public List<MemberDTO> list();
	public MemberDTO findById(String id);
	public List<MemberDTO> findByName(String name);
	public int count();
	public boolean login(MemberDTO param);
	public boolean existId(String id);
}
