package com.hanbit.web.services.impl;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.services.SubjectService;

/**
 * @date   :2016. 7. 26.
 * @author :장종익
 * @file   :SubjectServiceImpl.java
 * @story  :
*/
@Service
public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	
	private SubjectServiceImpl() {
	}
	
	public static SubjectService getInstance() {
		return instance;
	}

	@Override
	public void insert(SubjectDTO s) {
		System.out.println("서브젝트 서비스 : " + s);
	}
}
