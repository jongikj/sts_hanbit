package com.hanbit.web.subject;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @date   :2016. 7. 26.
 * @author :장종익
 * @file   :SubjectBean.java
 * @story  :
*/
@Component
public class SubjectVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id, major, subjects;
	private int subjseq;
	
	public int getSubjseq() {
		return subjseq;
	}

	public void setSubjseq(int subjseq) {
		this.subjseq = subjseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "SubjectBean [id=" + id + ", major=" + major + ", subjects=" + subjects + ", subjseq=" + subjseq + "]";
	}
}