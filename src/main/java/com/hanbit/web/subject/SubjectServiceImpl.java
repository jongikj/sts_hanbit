package com.hanbit.web.subject;

/**
 * @date   :2016. 7. 26.
 * @author :장종익
 * @file   :SubjectServiceImpl.java
 * @story  :
*/
public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	SubjectDAO dao = SubjectDAO.getInstance();
	
	private SubjectServiceImpl() {}
	
	public static SubjectService getInstance() {
		return instance;
	}

	@Override
	public void insert(SubjectBean s) {
		System.out.println("서브젝트 서비스 : " + s);
		dao.insert(s);
	}
}
