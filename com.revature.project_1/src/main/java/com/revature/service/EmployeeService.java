package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService {

	private static EmployeeService employeeService;
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getEmployeeService() {
		if(employeeService == null)
			employeeService = new EmployeeService();
		return employeeService;
	}

	public Employee getEmployee(String username, String password) {
		return EmployeeDaoImpl.getEmployeeDao().getEmployee(username, password);
	}
	
	public List<Employee> getEmployees(){
		return EmployeeDaoImpl.getEmployeeDao().getEmployees();
	}

}
