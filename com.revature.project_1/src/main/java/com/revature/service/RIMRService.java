package com.revature.service;

import java.sql.Date;

import com.revature.dao.RIMRDaoImpl;

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

}
