package com.hanbit.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	@RequestMapping("/detail")
	public String moveDetail(@RequestParam("key")String key){
		logger.info("SUBJECT KEY IS {}", key);
		return "user:subject/detail.tiles";
	}
}