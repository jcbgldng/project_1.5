package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;

import com.revature.handler.EmployeeHandler;
import com.revature.handler.FirstNameHandler;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/com.revature.project_1/UserFisrtName.ajax":
			return FirstNameHandler.getFirstName(req);
		case "/com.revature.project_1/viewEmployees.ajax":
			return EmployeeHandler.getEmployees();
		case "/com.revature.project_1/ViewEmployeeInformation.ajax":
			return EmployeeHandler.getEmployeeInformation(req);
		default :
			return " ";
		}
	}

}
