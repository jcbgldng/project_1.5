package com.revature.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.RIMRDaoImpl;
import com.revature.model.RIMR;

public class RIMRService {
	
	private static RIMRService rimrService = null;
	
	private RIMRService() {
	}

	public static RIMRService getRIMRService() {
		if(rimrService == null)
			rimrService = new RIMRService();
		return rimrService;
		
	}

	public void addRIMR(int amount, Date date_submitted, int employee_id) {
		RIMRDaoImpl.getRIMRDAO().addRIMR(amount, date_submitted, employee_id);
		
	}

	public List<RIMR> viewRequests(HttpServletRequest req) {
		return RIMRDaoImpl.getRIMRDAO().viewRequests(req);
	}

	public List<RIMR> viewPendingRequests(int employee_id) {
		return RIMRDaoImpl.getRIMRDAO().viewPendingRequests(employee_id);
	}

	public List<RIMR> viewResolvedRequests(int employee_id) {
		return RIMRDaoImpl.getRIMRDAO().viewResolvedRequests(employee_id);
	}

	public List<RIMR> viewAllPendingRIMR() {
		return RIMRDaoImpl.getRIMRDAO().viewAllPendingRIMR();
	}

	public List<RIMR> viewAllResolvedRIMR() {
		return RIMRDaoImpl.getRIMRDAO().viewAllResolvedRIMR();
	}

	public void ResolveRIMR(int rimr_id, String decision, Date date_resolved, int manager_id) {
		RIMRDaoImpl.getRIMRDAO().ResolveRIMR(rimr_id, decision, date_resolved, manager_id);
		
	}

	public List<RIMR> viewAllPendingRIMRofEmployee(int em_id) {
		return RIMRDaoImpl.getRIMRDAO().viewAllPendingRIMRofEmployee(em_id);
	}

}
