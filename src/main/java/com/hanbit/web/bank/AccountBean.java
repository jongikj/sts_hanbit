package com.hanbit.web.bank; 

import java.io.Serializable;

import com.hanbit.web.global.Constants;

/**
 * @date   :2016. 6. 16.
 * @author :장종익
 * @file   :Account.java
 * @story  :
*/
public class AccountBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountNo; // 인스턴스 변수는 초기화를 하지 않는다.
	private int money;
	private String name;
	private String pw;
	private String id; // 속성은 감추고 기능은 드러낸다.(은닉화)
	private String regDate;
	private String ssn;
	
	public AccountBean() { // default Constructor
		// 생성자 오버로딩
	}

	public AccountBean(int accountNo, int money, String id, String pw, String name, String regDate, String ssn){
		this.accountNo = accountNo;
		this.money = money;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regDate = regDate;
		this.ssn = ssn;
	}
	
	public AccountBean(String name, String id, String pw) {
		this.accountNo = (int) (Math.random() * 999999) + 100000;
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setAccountNo() {
		int rn = (int) (Math.random() * 999999) + 100000;
			this.accountNo = rn;
	}
	
	public void setAccountNo(int accNo){
		this.accountNo = accNo;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAccountNo() {
		return this.accountNo;
	}
	
	public int getOnlyAccountNo(){
		return this.accountNo;
	}

	public int getMoney() {
		return this.money;
	}

	public String getName() {
		return this.name;
	}

	public String getPw() {
		return this.pw;
	}

	public String getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return Constants.BANK_NAME + "[계좌번호 : " + accountNo + ", 잔액 : " + money + ", ID : " + id + ", 비밀번호 : " + pw + 
				", 이름 : " + name + ", 등록일자 : " + regDate + ", 주민등록번호 : " + ssn + "]\n";
	}
}