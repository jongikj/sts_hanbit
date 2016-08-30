package com.hanbit.web.util;

import com.hanbit.web.bank.AccountDAOImpl;
import com.hanbit.web.bank.AccountVO;
import com.hanbit.web.grade.GradeDAOImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.member.MemberVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectVO;

public class Test {
	public String test(){
		MemberVO m = MemberDAOImpl.getInstance().findById("hong");
		return m.toString();
	}
	
	public String testAccount(){
		AccountVO a = AccountDAOImpl.getInstance().findByAccountNo(123456);
		return a.toString();
	}
	
	public String testGrade(){
		GradeVO g = GradeDAOImpl.getInstance().findBySeq("1020");
		return g.toString();
	}
	
	public String testSubject(){
		SubjectVO s = SubjectDAOImpl.getInstance().findById("jang");
		return s.toString();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.test());
		System.out.println(t.testAccount());
		System.out.println(t.testGrade());
		System.out.println(t.testSubject());
	}
}
