package com.hanbit.web.grade;

import com.hanbit.web.util.CommonService;

public interface GradeService extends CommonService{
	// 총 7개의 기본패턴
	//exeU
	public String insert(GradeBean bean);
	public GradeBean findBySeq(String seq);
	public String update(String seq, String sub, GradeBean bean);
	public String delete(String seq);
	//exeQ
	public void score(String[] arr);
	public int count(String examDate);
}
