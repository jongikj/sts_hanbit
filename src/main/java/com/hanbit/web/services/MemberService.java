/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;

/**
 * @date   :2016. 6. 17.
 * @author :장종익
 * @file   :StudentService.java
 * @story  :
*/
public interface MemberService {
	public String regist(MemberDTO member);
	public String update(MemberDTO member);
	public void delete(MemberDTO member);
	public MemberDTO findOne(Command command);
	public List<MemberDTO> findByName(String findName);
	public int existId(String id);
	public MemberDTO findBy();
	public void logout(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public List<?> list(Command command);
}
