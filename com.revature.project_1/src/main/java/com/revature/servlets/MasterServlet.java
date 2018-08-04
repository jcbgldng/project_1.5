package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class log_in
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);
		} catch (Exception e) {
			//Employee or manager logged in fine
		} 
	}
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	try {
    		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,resp);
		} catch (Exception e) {
			// Employee or manager logged in fine
		} 
    }

}