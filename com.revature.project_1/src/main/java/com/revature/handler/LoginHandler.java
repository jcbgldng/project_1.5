package com.revature.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

public class LoginHandler {

	public static String login(HttpServletRequest req) {
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String[] type = req.getParameterValues("type");
    	
    	if(type[0].equals("manager"))
    		return managerLogin(username, password, req);
    	else if(type[0].equals("employee"))
    		return employeeLogin(username, password, req);
    	return null;
    		
	}
	
	private static String employeeLogin(String username, String password, HttpServletRequest req) {
		Employee theEmployee = null;
		theEmployee = EmployeeService.getEmployeeService().getEmployee(username, password);
		
		if(theEmployee != null) {
    		HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = req.getSession(true);
    		
            newSession.setAttribute("employeeid", theEmployee.getEmployee_id());
            newSession.setAttribute("employeeFirstname", theEmployee.getFirstName());
            newSession.setAttribute("employeeLastname", theEmployee.getLastName());
    		
    		return "/html/employee.jsp";
    	}
    	else
    		return "/html/index.html";
	}

	public static String managerLogin(String username, String password, HttpServletRequest req) {
		Manager theManager = null;
		theManager = ManagerService.getManagerService().getManager(username, password);
    	
    	if(theManager != null) {
    		HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = req.getSession(true);
    		
            newSession.setAttribute("managerid", theManager.getUser_id());
            newSession.setAttribute("managerFirstname", theManager.getFirstName());
            newSession.setAttribute("managerLastname", theManager.getLastName());
    		
    		return "/html/manager.jsp";
    	}
    	else
    		return "/html/index.html";
	}


}
