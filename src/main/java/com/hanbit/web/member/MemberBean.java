package com.hanbit.web.member;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date   :2016. 6. 16.
 * @author :장종익
 * @file   :Student.java
 * @story  :
*/
public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id, pw, name, regDate, gender, ssn, profileImg, email, phone;
	private int birth;
	
	public MemberBean() {
	}
	
	public MemberBean(String name, String id, String pw, String ssn) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.gender = null;
		this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
		String[] arr = new String[2];
		arr = ssn.split("-");

//		if (Integer.parseInt(arr[1]) == 0 || Integer.parseInt(arr[1]) == 9) {
//		}

		switch (Integer.parseInt(arr[1]) % 2) {
		case 1:
			this.gender = "남";
			break;
		default:
			this.gender = "여";
			break;
		}
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSsn(String ssn){
		this.ssn = ssn;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setRegDate() {
		this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
	}
	
	public void setRegDate(String regDate){
		this.regDate = regDate;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getId() {
		return this.id;
	}
	
	public String getPw(){
		return this.pw;
	}

	public String getName() {
		return this.name;
	}

	public String getRegDate() {
		return this.regDate;
	}
	
	public void setGenderAndBirth(String ssn) {
		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.regDate = now;
		String[] ssnArr = ssn.split("-");
		String[] nowArr = now.split("-");
		int ssnBirth = (Integer.parseInt(ssnArr[0]));
		int ssnGender = (Integer.parseInt(ssnArr[1]));
		int thisYear = (Integer.parseInt(nowArr[0]));
		int age = 0;
		switch (ssnGender) {
		case 1: case 5: 
			this.gender="남"; 
//			age = ageResult2 - 1900-(ageResult1/10000);
//			나이를 구하려고 했으나 보류
			this.birth = ssnBirth;
			break;
		case 3: case 7:
			this.gender="남"; 
			this.birth = ssnBirth;
			break;
		case 2: case 6:
			this.gender="여";
			this.birth = ssnBirth;
			break;
		case 4: case 8:
			this.gender="여";
			this.birth = ssnBirth;
			break;
		default:
			System.out.println("잘못된값이 입력됨");
		}
	}

	public String getGender() {
		return this.gender;
	}

	public String getSsn() {
		return this.ssn;
	}
	
	public int getBirth() {
		return this.birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
/*
	@Override
	public String toString() {
		return "id=" + id + ", pw=" + pw + ", 이메일=" + email + ", 이름=" + name + ", 등록일=" + regDate + ", 성별=" + gender
				+ ", 주민번호=" + ssn + ", 나이=" + birth;
	}
*/

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", regDate=" + regDate + ", gender=" + gender
				+ ", ssn=" + ssn + ", profileImg=" + profileImg + ", email=" + email + ", phone=" + phone + ", birth="
				+ birth + "]";
	}
}