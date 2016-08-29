package com.hanbit.web.bank;

/**
 * @date :2016. 7. 8.
 * @author :장종익
 * @file :AccountMemberBean.java
 * @story :
 */
public class AccountMemberVO {
	private String id, pw, name, regDate, gender, ssn, birth;
	private int money, accountNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "ID : " + id + ", 이름 : " + name + ", 생년월일 : " + birth + ", 잔액 : " + money + "원, 계좌번호 : "
				+ accountNo;
	}
}