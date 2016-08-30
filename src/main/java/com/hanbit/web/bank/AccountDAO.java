package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

public interface AccountDAO {
	public int insertAccount(AccountVO bean);
	public int deposit(AccountVO bean);
	public void withdraw(AccountVO bean);
	public int updateAccount(AccountVO bean);
	public int deleteAccount(int accountNo);
	public List<?> selectAll();
	public AccountVO findByAccountNo(int searchAcc);
	public List<?> findByName(String name);
	public int count();
	public int selectMoney(int accountNo);
	public Map<?, ?> selectMap();
}
