package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class log_in
 */
public class log_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log_in() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String[] type = req.getParameterValues("type");
    	
    	
    	if(type[0].equals("manager"))
    		resp.sendRedirect("http://localhost:8080/com.revature.project_1/html/manager.html");
    	else
    		resp.sendRedirect("https://www.google.com/");
    }

}
