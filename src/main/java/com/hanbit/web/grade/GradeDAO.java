package com.hanbit.web.grade;

import java.util.List;

public interface GradeDAO {
	public int insert(GradeVO grade);
	public int update(String seq, String sub, GradeVO grade);
	public int delete(String seq);
	public List<?> list();
	public GradeVO findBySeq(String seq);
	public GradeVO findById(String id);
	public int count(String examDate);
}
