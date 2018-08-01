package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.handler.LoginHandler;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/com.revature.project_1/html/log_in.do":
			return LoginHandler.login(req);
		default :
			return "404.jsp";
		}
	}

	

}
