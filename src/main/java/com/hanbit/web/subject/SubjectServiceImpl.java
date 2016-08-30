package com.hanbit.web.subject;

import org.springframework.stereotype.Service;

/**
 * @date   :2016. 7. 26.
 * @author :장종익
 * @file   :SubjectServiceImpl.java
 * @story  :
*/
@Service
public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	SubjectDAOImpl dao = null;
	
	private SubjectServiceImpl() {
		dao = SubjectDAOImpl.getInstance();
	}
	
	public static SubjectService getInstance() {
		return instance;
	}

	@Override
	public void insert(SubjectVO s) {
		System.out.println("서브젝트 서비스 : " + s);
		dao.insert(s);
	}
}
