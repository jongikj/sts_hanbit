/**
 * 
 */
package com.hanbit.web.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :AccountServiceImpl.java
 * @story  :계좌 인터페이스
*/
@Service
public class AccountServiceImpl implements AccountService {
	private static AccountServiceImpl instance = new AccountServiceImpl();
	AccountDAOImpl dao = null;
	private Map<?, ?> map; 
	
	public static AccountServiceImpl getInstance() {
		return instance;
	}

	private AccountServiceImpl() {
		map = new HashMap<String, AccountMemberVO>();
		dao = AccountDAOImpl.getInstance();
	}
	
	@Override
	public String openAccount(String id) {
		AccountVO bean = new AccountVO();
		String msg = "";
		bean.setAccountNo();
		bean.setId(id);
		bean.setMoney(0);
		
		if(dao.insertAccount(bean) == 1){
			msg = "생성완료";
		} else {
			msg = "생성실패";
		}
		return msg;
	}

	@Override
	public void deposit(String deposit) {
		String[] arr = deposit.split(",");
		AccountVO bean = new AccountVO();
		bean.setAccountNo(Integer.parseInt(arr[0]));
		int money = this.restMoney(Integer.parseInt(arr[0])) + Integer.parseInt(arr[1]);
		bean.setMoney(money);
		dao.deposit(bean);
	}

	@Override
	public String withdraw(String withdraw) {
		String result = "";
		String[] arr = withdraw.split(",");
		AccountVO bean = new AccountVO();
		bean.setAccountNo(Integer.parseInt(arr[0]));
		int restMoney = this.restMoney(Integer.parseInt(arr[0]));
		int withdrawMoney = Integer.parseInt(arr[1]);

		if (restMoney < withdrawMoney) {
			result = "잔액이 부족합니다";
		} else {
			bean.setMoney(restMoney - withdrawMoney);
			dao.withdraw(bean);
			result = "잔액 : " + String.valueOf(this.restMoney(Integer.parseInt(arr[0])));
		}
		return result;
	}

	@Override
	public String updateAccount(AccountVO bean) {
		String msg = "";

		if (dao.updateAccount(bean) == 1) {
			msg = "수정완료";
		} else {
			msg = "수정실패";
		}
		return msg;
	}

	@Override
	public String deleteAccount(int accountNo) {
		String msg = "";

		if (dao.deleteAccount(accountNo) == 1) {
			msg = "삭제완료";
		} else {
			msg = "삭제실패";
		}
		return msg;
	}

	@Override
	public List<?> list() {
		return dao.selectAll();
	}

	@Override
	public AccountVO findByAccountNo(int searchAcc) {
		return dao.findByAccountNo(searchAcc);
	}

	@Override
	public List<?> findBy(String name) {
		return dao.findByName(name);
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public int restMoney(int accountNo) {
		return dao.selectMoney(accountNo);
	}

	@Override
	public Map<?, ?> map() {
		map = new HashMap<String, AccountMemberVO>();
		map  = dao.selectMap();
		return map;
	}
}