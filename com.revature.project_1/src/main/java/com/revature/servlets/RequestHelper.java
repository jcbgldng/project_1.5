package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.handler.LoginHandler;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		//System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/com.revature.project_1/html/log_in.do":
			return LoginHandler.login(req);
		case "/com.revature.project_1/html/logOut.do":
			return LoginHandler.logout(req);
		case "/com.revature.project_1/Employee.do":
			return LoginHandler.employeeLoggedIn(req);
		case "/com.revature.project_1/Manager.do":
			return LoginHandler.managerLoggedIn(req);
		default :
			return "404.jsp";
		}
	}

	

}
