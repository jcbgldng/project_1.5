package com.revature.handler;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeHandler {

	public static String getEmployees() {
		List<Employee> employeeList =  new ArrayList<Employee>();
		employeeList = EmployeeService.getEmployeeService().getEmployees();
		String returnHtml = "<table><thead><th>Employee ID</th><th>First Name</th><th>Last Name</th></thead><tbody>";
		
		for (Employee employee : employeeList) {
			returnHtml = returnHtml + "<tr>";
			returnHtml = returnHtml + "<td>" + employee.getEmployee_id() + "</td>";
			returnHtml = returnHtml + "<td>" + employee.getFirstName() + "</td>";
			returnHtml = returnHtml + "<td>" + employee.getLastName() + "</td>";
			returnHtml = returnHtml + "</tr>";
		}
		returnHtml = returnHtml + "</tbody></table>";
		return returnHtml;
	}

}
 