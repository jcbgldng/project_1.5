package com.revature.handler;

import java.util.ArrayList;
import java.util.Enumeration;
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

	public static String GetChangeForm(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String returnHtml = "<form id=\"UserInformationForm\" action=\"javascript:void(0);\" onsubmit=\"ChangeEmployeeInformation()\">";
		
		returnHtml = returnHtml + "First Name <br><input type=\"text\" name=\"FirstName\" value=\"";
		returnHtml = returnHtml + session.getAttribute("employeeFirstname") +"\"><br>";
		
		returnHtml = returnHtml + "Last Name <br><input type=\"text\" name=\"LastName\" value=\"";
		returnHtml = returnHtml + session.getAttribute("employeeLastname") +"\"><br>";
		
		returnHtml = returnHtml + "Address <br><input type=\"text\" name=\"Address\" value=\"";
		returnHtml = returnHtml + session.getAttribute("employeeAddress") +"\"><br>";
		
		returnHtml = returnHtml + "Phone Number <br><input type=\"text\" name=\"Phone\" value=\"";
		returnHtml = returnHtml + session.getAttribute("employeePhone") +"\"><br>";
		
		returnHtml = returnHtml + "Email <br><input type=\"text\" name=\"Email\" value=\"";
		returnHtml = returnHtml + session.getAttribute("employeeEmail") +"\"><br>";
		
		returnHtml = returnHtml + "<input type =\"submit\" value=\"go\"></form>";
		
		
		return returnHtml;
	}

	public static String UpdateEmployeeInformation(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int employee_id = (int) session.getAttribute("employeeid");
		String firstName = req.getParameter("FirstName");
    		String lastName = req.getParameter("LastName");
    		String address = req.getParameter("Address");
    		String phone = req.getParameter("Phone");
    		String email = req.getParameter("Email");
    	

		Employee theEmployee = null;
		
		theEmployee = EmployeeService.getEmployeeService().updateEmployee(employee_id, firstName, lastName, address, phone, email);
		
		session.setAttribute("employeeid", theEmployee.getEmployee_id());
		session.setAttribute("employeeFirstname", theEmployee.getFirstName());
		session.setAttribute("employeeLastname", theEmployee.getLastName());
		session.setAttribute("employeeAddress", theEmployee.getAddress());
		session.setAttribute("employeePhone", theEmployee.getPhoneNumber());
		session.setAttribute("employeeEmail", theEmployee.getEmail());
		
		return getEmployeeInformation(req);
	}
	

}
 