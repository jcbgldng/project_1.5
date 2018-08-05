package com.revature.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FirstNameHandler {

	public static String getFirstName(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return  (String) session.getAttribute("managerFirstname");
	}
	

}
