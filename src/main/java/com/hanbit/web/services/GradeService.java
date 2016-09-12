package com.hanbit.web.services;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.util.CommonService;

public interface GradeService extends CommonService{
	// 총 7개의 기본패턴
	//exeU
	public String insert(GradeDTO bean);
	public GradeDTO findBySeq(String seq);
	public String update(String seq, String sub, GradeDTO bean);
	public String delete(String seq);
	//exeQ
	public void score(String[] arr);
	public int count(String examDate);
	public GradeDTO findById(String id);
}
