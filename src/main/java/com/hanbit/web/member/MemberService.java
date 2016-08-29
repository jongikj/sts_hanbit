/**
 * 
 */
package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.util.CommonService;

/**
 * @date   :2016. 6. 17.
 * @author :장종익
 * @file   :StudentService.java
 * @story  :
*/
public interface MemberService extends CommonService{
	public String regist(MemberVO bean);
	public void update(MemberVO bean);
	public void delete(MemberVO bean);
	public MemberVO findById(String id);
	public List<MemberVO> findByName(String findName);
	public SubjectMemberVO login(MemberVO bean);
	public boolean existId(String id);
	public MemberVO findBy();
	public void logout(MemberVO bean);
}
