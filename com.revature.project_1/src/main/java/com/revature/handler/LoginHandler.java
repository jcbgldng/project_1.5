package com.revature.handler;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Manager;
import com.revature.service.ManagerService;

public class LoginHandler {

	public static String login(HttpServletRequest req) {
		Manager theManager = null;
    	//Employee theEmployee = null;
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String[] type = req.getParameterValues("type");
    	
    	if(type[0].equals("manager"))
    		theManager = ManagerService.getManagerService().getManager(username, password);
    	
    	System.out.println(theManager);
    	
    	if(theManager != null) {
    		req.getSession().setAttribute("manager", theManager);
    		
    		return "/html/manager.jsp";
    	}
    	else
    		return "/html/index.html";
	}


}
