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
		return "admin:account/content.tiles";
	}
	
	@RequestMapping("/open")
	public String moveOpen() {
		logger.info("GO TO {}", "open");
		return "user:account/open.tiles";
	}
	
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO {}", "detail");
		return "user:account/detail.tiles";
	}
	
	@RequestMapping("/transaction")
	public String moveTransaction() {
		logger.info("GO TO {}", "transaction");
		return "user:account/transaction.tiles";
	}
	
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}", "delete");
		return "user:account/open.tiles";
	}
	
	@RequestMapping("/list")
	public String moveList() {
		logger.info("AccountController! moveList()..");
		return "admin:account/list.tiles";
	}
	
	@RequestMapping("/find")
	public String moveFind() {
		logger.info("AccountController! moveFind()..");
		return "admin:account/find.tiles";
	}
	
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("AccountController! moveCount()..");
		return "admin:account/count.tiles";
	}
	
}
