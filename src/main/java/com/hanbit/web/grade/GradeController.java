package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GradeController! moveMain()..");
		return "grade/content.tiles";
	}
	
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("GradeController! moveCount()..");
		return "grade/count.tiles";
	}
	
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("GradeController! moveRegist()..");
		return "grade/regist.tiles";
	}
	
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GradeController! moveUpdate()..");
		return "grade/update.tiles";
	}
	
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GradeController! moveDelete()..");
		return "grade/delete.tiles";
	}
	
	@RequestMapping("/list")
	public String moveList() {
		logger.info("GradeController! moveList()..");
		return "grade/list.tiles";
	}
	
	@RequestMapping("/search")
	public String moveSearch() {
		logger.info("GradeController! moveSearch()..");
		return "grade/search.tiles";
	}
}
