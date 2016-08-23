package com.hanbit.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date   :2016. 7. 22.
 * @author :장종익
 * @file   :DispatcherServlet.java
 * @story  :
*/
public class DispatcherServlet {
	public static void send(HttpServletRequest request, HttpServletResponse response, Command command) throws ServletException, IOException{
		System.out.println("이동할 페이지" + command.getView());
		request.getRequestDispatcher(command.getView()).forward(request, response);
	}
}