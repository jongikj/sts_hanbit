package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.mappers.GradeMapper;
import com.hanbit.web.services.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	private static GradeServiceImpl instance = new GradeServiceImpl();
	@Qualifier GradeMapper mapper;
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public String insert(GradeDTO bean) {
		String msg = "";
		return msg;
	}

	@Override
	public String update(String seq, String sub, GradeDTO bean) {
		String msg = "";
		return msg;
	}

	@Override
	public String delete(String seq) {
		String msg = "";
		return msg;
	}

	@Override
	public GradeDTO findBySeq(String seq) {
		return null;
	}
	
	@Override
	public List<?> list() {
		return null;
	}

	@Override
	public GradeDTO findById(String id) {
		return null;
	}

	@Override
	public int count(String examDate) {
		return 0;
	}

	@Override
	public Map<?, ?> map() {
		return null;
	}

	@Override
	public void score(String[] arr) {
		
	}

	@Override
	public List<?> findBy(String keyword) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}
}