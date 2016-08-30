package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword")String keyword, @RequestParam("search_option")String option, Model model, 
			@RequestParam("context")String context){
		System.out.println("검색어 : " + keyword);
		System.out.println("옵션 : " + option);
		MemberVO member = (MemberVO) service.findById("hong");
		logger.info("MemberController ! findById : {}", member.getName());
		System.out.println("NAME : " + member.getName());
		System.out.println("이미지  : " + member.getProfileImg());
		model.addAttribute("member", member);
		model.addAttribute("img", context + "/resources/img");
		return "admin:member/detail.tiles";
	}
	
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("MemberController! moveMain()..");
		return "admin:member/content.tiles";
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
		return "admin:member/list.tiles";
	}

	@RequestMapping("/find_by")
	public String moveFindBy() {
		logger.info("MemberController! moveFindBy()");
		return "admin:member/find_by.tiles";
	}

	@RequestMapping("/count")
	public String moveCount() {
		logger.info("MemberController! moveCount()");
		return "admin:member/count.tiles";
	}
}
