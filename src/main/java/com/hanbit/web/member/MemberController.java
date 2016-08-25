package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.HomeController;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("MemberController! moveMain()..");
		return "member/content.tiles";
	}
	
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("MemberController! moveRegist()");
		return "public:member/regist.tiles";
	}

	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("MemberController! moveDetail()");
		return "member/detail.tiles";
	}

	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("MemberController! moveUpdate()");
		return "member/update.tiles";
	}

	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("MemberController! moveDelete()");
		return "member/delete.tiles";
	}

	@RequestMapping("/login")
	public String moveLogin() {
		logger.info("MemberController! moveLogin()");
		return "public:member/login.tiles";
	}

	@RequestMapping("/logout")
	public String moveLogout() {
		logger.info("MemberController! moveLogout()");
		return "member/logout.tiles";
	}

	@RequestMapping("/list")
	public String moveList() {
		logger.info("MemberController! moveList()");
		return "member/list.tiles";
	}

	@RequestMapping("/find_by")
	public String moveFindBy() {
		logger.info("MemberController! moveFindBy()");
		return "member/find_by.tiles";
	}

	@RequestMapping("/count")
	public String moveCount() {
		logger.info("MemberController! moveCount()");
		return "member/count.tiles";
	}
}
