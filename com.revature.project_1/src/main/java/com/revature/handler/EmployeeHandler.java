package com.revature.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	public static String getEmployeeInformation(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String returnHtml = "<table><thead><th>First Name</th><th>Last Name</th><th>Address</th><th>Phone</th><th>Email</th></thead><tbody>";
		returnHtml = returnHtml + "<tr><td>"+ session.getAttribute("employeeFirstname") +"</td>";
		returnHtml = returnHtml + "<td>"+ session.getAttribute("employeeLastname") +"</td>";
		returnHtml = returnHtml + "<td>"+ session.getAttribute("employeeAddress") +"</td>";
		returnHtml = returnHtml + "<td>"+ session.getAttribute("employeePhone") +"</td>";
		returnHtml = returnHtml + "<td>"+ session.getAttribute("employeeEmail") +"</td></tr>";
		returnHtml = returnHtml + "</tbody></table>";

		return returnHtml;
	}
	

}
 