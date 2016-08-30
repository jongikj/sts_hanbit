package com.hanbit.web.subject;

public interface SubjectDAO {
	public int insert(SubjectVO sub);
	public SubjectVO findById(String id);
}
