package com.hanbit.web.mappers;

import java.util.List;

import com.hanbit.web.domains.GradeDTO;

public interface GradeMapper {
	public int insert(GradeDTO grade);
	public int update(String seq, String sub, GradeDTO grade);
	public int delete(String seq);
	public List<?> list();
	public GradeDTO findBySeq(String seq);
	public GradeDTO findById(String id);
	public int count(String examDate);
}
