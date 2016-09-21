package com.hanbit.web.mappers;

import java.util.List;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;

public interface MemberMapper {
	public int insert(MemberDTO member);
	public int update(MemberDTO member);
	public int delete(MemberDTO member);
	public List<MemberDTO> list();
	public MemberDTO findOne(Command command);
	public List<MemberDTO> findByName(String name);
	public int count();
	public boolean login(MemberDTO param);
	public int existId(String id);
}
