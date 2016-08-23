package com.hanbit.web.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("AccountController! moveMain()..");
		return "account/content.tiles";
	}
	
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("AccountController! moveRegist()..");
		return "account/regist.tiles";
	}
	
	@RequestMapping("/deposit")
	public String moveDeposit() {
		logger.info("AccountController! moveDeposit()..");
		return "account/deposit.tiles";
	}
	
	@RequestMapping("/withdraw")
	public String moveWithdraw() {
		logger.info("AccountController! moveWithdraw()..");
		return "account/withdraw.tiles";
	}
	
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("AccountController! moveUpdate()..");
		return "account/update.tiles";
	}
	
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("AccountController! moveDelete()..");
		return "account/delete.tiles";
	}
	
	@RequestMapping("/list")
	public String moveList() {
		logger.info("AccountController! moveList()..");
		return "account/list.tiles";
	}
	
	@RequestMapping("/search")
	public String moveSearch() {
		logger.info("AccountController! moveSearch()..");
		return "account/search.tiles";
	}
	
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("AccountController! moveCount()..");
		return "account/count.tiles";
	}
	
}
