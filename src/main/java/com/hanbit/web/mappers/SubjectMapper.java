package com.hanbit.web.mappers;


import com.hanbit.web.domains.SubjectDTO;

public interface SubjectMapper {
	public int insert(SubjectDTO sub);
	public SubjectDTO findById(String id);
}
