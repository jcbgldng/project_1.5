package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	public Employee getEmployee(String username, String password);
	public List<Employee> getEmployees();
}
