package com.revature.service;

import com.revature.dao.ManagerDaoImpl;
import com.revature.model.Manager;

public class ManagerService {
	
	private static ManagerService managerService;
	
	private ManagerService() {}
	
	public static ManagerService getManagerService() {
		if(managerService == null)
			managerService = new ManagerService();
		return managerService;
	}
	
	public Manager getManager(String username, String password) {
		return ManagerDaoImpl.getManagerDao().getManager(username, password);
	}
}
