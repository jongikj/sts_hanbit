package com.hanbit.web.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.services.impl.MemberServiceImpl;

public class Pagingnation {
	@Autowired MemberServiceImpl service;
	
	public void test(){
		int pgNum = 1;
		int totCount = service.count(); 
		int startRow = 0;
		int endRow = 0;
		int pgCount = 0;
		
		if(totCount % MemberController.PG_SIZE == 0){
			pgCount = totCount / MemberController.PG_SIZE;
		} else {
			pgCount = (totCount / MemberController.PG_SIZE) + 1;
		}
		
		if(pgNum == 1 && totCount > 0){
			startRow = 1;
		} else if(pgNum > 1) {
		}
	}
}
