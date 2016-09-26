package com.hanbit.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;

@Controller
@SessionAttributes({"user", "context", "css", "img", "js"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	public static int PG_SIZE = 5;
	@Autowired MemberServiceImpl service;
	@Autowired MemberDTO member;
	@Autowired Command command;
	@Autowired Retval retval;
	
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option")String option, @PathVariable("keyword")String keyword, Model model){
		logger.info("TO SEARCH KEYWORD IS {}", keyword);
		logger.info("TO SEARCH OPTION IS {}", option);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	
	@RequestMapping(value="/count/{option}", consumes="application/json")
	public Model count(@PathVariable("option") String option, Model model){
		logger.info("TO COUNT CONDITION IS {}", option);
		model.addAttribute("count", service.count());
		return model;
	}
	
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("THIS PATH IS {}", "LOGINED_HEADER");
		return "user/header.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody MemberDTO login(@RequestParam("id")String id, @RequestParam("pw")String pw, Model model) {
		logger.info("TO LOGIN ID IS {}", id);
		logger.info("TO LOGIN PW IS {}", pw);
		member.setId(id);
		member.setPw(pw);
		MemberDTO user = service.login(member);
		if(user.getId().equals("NONE")){
			logger.info("Controller LOGIN {}", "FAIL");
			return user;
		}else{
			logger.info("Controller LOGIN {}", "SUCCESS");
			model.addAttribute("user", user);
			return user;
		}
	}
	
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}", "main");
		return "admin:member/content.tiles";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Retval signUp(@RequestBody MemberDTO param) {
		logger.info("SIGN UP {}", "EXECUTE");
		logger.info("SIGN UP ID = {}", param.getId());
		logger.info("SIGN UP PW = {}", param.getPw());
		logger.info("SIGN UP NAME = {}", param.getName());
		logger.info("SIGN UP SSN = {}", param.getSsn());
		logger.info("SIGN UP EMAIL = {}", param.getEmail());
		logger.info("SIGN UP PHONE = {}", param.getPhone());
		retval.setMessage(service.regist(param));
		logger.info("SIGN UP RETBAL = {} ", retval.getMessage());
		return retval;
	}
	
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval checkDup(@PathVariable String id) {
		logger.info("CHECK DUP {}", "EXECUTE");
		if(service.existId(id) == 1){
			retval.setFlag("TRUE");
			retval.setMessage("중복되는 ID 입니다.");
		} else {
			retval.setFlag("FALSE");
			retval.setMessage("사용가능한 ID 입니다.");
			retval.setTemp(id);
		}
		logger.info("RETVAL FLAG IS {}", retval.getFlag());
		logger.info("RETVAL MSG IS {}", retval.getMessage());
		return retval;
	} 
	
	@RequestMapping("/list/{pgNum}")
	public String list(@PathVariable String strPgNum, Model model){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int pgNum = Integer.parseInt(strPgNum);
		int totCount = service.count();
		int startRow = 0;
		int endRow = 0;
		int pgCount = totCount/PG_SIZE;
		if((totCount % PG_SIZE) == 0){
			startRow = 0;
			endRow = 0;
		} else {
			startRow = 0;
			endRow = 0;
		}
		command.setStart(startRow);
		command.setEnd(endRow);
		model.addAttribute("list", service.list(command));
		return "admin:member/list.tiles";
	}
	
	@RequestMapping("/search")
	public String search(
			@RequestParam(value="keyField") String keyField, 
			@RequestParam(value="keyword") String keyword, 
			@RequestParam(value="pgNum") String pgNum, 
			Model model){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
//		service.list();
		model.addAttribute("list", list);
		return "admin:member/list.tiles";
	}
	
	@RequestMapping("/detail")
	public @ResponseBody MemberDTO moveDetail(HttpSession session) {
		logger.info("GO TO {}", "detail");
		return (MemberDTO) session.getAttribute("user");
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody Retval update(@RequestBody MemberDTO param, HttpSession session) {
		logger.info("GO TO {}", "update");
		MemberDTO temp = (MemberDTO) session.getAttribute("user");
		temp.setPw(param.getPw());
		temp.setEmail(param.getEmail());
		retval.setMessage(service.update(temp));
		return retval;
	}
	
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key")String key) {
		logger.info("GO TO {}", "a_detail");
		logger.info("KEY IS {}", key);
		return "admin:member/a_detail.tiles";
	}

	/*@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GO TO {}", "update");
		return "user:member/update.tiles";
	}*/

	/*@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}", "delete");
		return "user:member/delete.tiles";
	}*/

	@RequestMapping("/login")
	public String login() {
		logger.info("GO TO {}", "login");
		return "public:member/login.tiles";
	}

	@RequestMapping("/logout")
	public String moveLogout(SessionStatus status) {
		logger.info("GO TO {}", "LOGOUT");
		status.setComplete();
		logger.info("SESSION IS {}", "CLEAR");
		return "redirect:/";
	}

	@RequestMapping("/list")
	public String moveList() {
		logger.info("GO TO {}", "list");
		return "admin:member/list.tiles";
	}

	@RequestMapping("/find_by")
	public String moveFindBy() {
		logger.info("GO TO {}", "find_by");
		return "admin:member/find_by.tiles";
	}

	@RequestMapping("/count")
	public String moveCount() {
		logger.info("GO TO {}", "count");
		return "admin:member/count.tiles";
	}
	
	@RequestMapping("/content")
	public String moveUserContent() {
		logger.info("GO TO {}", "content");
		return "user:user/content.tiles";
	}
	
	@RequestMapping("/kaup")
	public String moveKaup() {
		logger.info("GO TO {}", "kaup");
		return "user:user/kaup.tiles";
	}
	
	@RequestMapping("/rock_scissor_paper")
	public String moveRockScissorPaper() {
		logger.info("GO TO {}", "rock_scissor_paper");
		return "user:user/rock_scissor_paper.tiles";
	}
	
	@RequestMapping("/lotto")
	public String movelotto() {
		logger.info("GO TO {}", "lotto");
		return "user:user/lotto.tiles";
	}
}
