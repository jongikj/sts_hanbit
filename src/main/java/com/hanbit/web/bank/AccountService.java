package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

import com.hanbit.web.global.CommonService;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :AccountService.java
 * @story  :
*/
public interface AccountService extends CommonService { 
	// 1.개설
	public String openAccount(String id);
	// 2.입금
	public void deposit(String deposit);
	// 3.출금
	public String withdraw(String withdraw);
	// UPDATE : 4.수정 .. 사용자의 요청에 의해 비번만 전환가능
	public String updateAccount(AccountBean bean);
	// 5.해지
	public String deleteAccount(int accountNo);
	// READ : 7.조회 (계좌번호)
	public AccountBean findByAccountNo(int searchAcc);
	// 필요에 따라 생성하는 메소드
	public int restMoney(int accountNo);
}