package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GradeServiceImpl implements GradeService {
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	private GradeServiceImpl() {}
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public String insert(GradeVO bean) {
		String msg = "";
		if (dao.insert(bean) == 1){
			msg = "추가성공";
		} else {
			msg = "추가실패";
		}
		return msg;
	}

	@Override
	public String update(String seq, String sub, GradeVO bean) {
		String msg = "";
		if (dao.update(seq, sub, bean) == 1) {
			msg = "수정완료";
		} else {
			msg = "수정실패";
		}
		return msg;
	}

	@Override
	public String delete(String seq) {
		String msg = "";
		if (dao.delete(seq) == 1) {
			msg = "삭제성공";
		} else {
			msg = "삭제실패";
		}
		return msg;
	}

	@Override
	public GradeVO findBySeq(String seq) {
		return dao.findBySeq(seq);
	}
	
	@Override
	public List<?> list() {
		List<?> list = dao.list();
		return list;
	}

	@Override
	public List<?> findBy(String id) {
		List<?> list = new ArrayList<GradeVO>();
		list = dao.findById(id);
		return list;
	}

	@Override
	public int count() {
		return dao.count();
	}
	
	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}

	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void score(String[] arr) {
		// TODO Auto-generated method stub
		
	}
}