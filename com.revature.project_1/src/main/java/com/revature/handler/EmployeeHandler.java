package com.revature.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.model.RIMR;
import com.revature.service.EmployeeService;
import com.revature.service.RIMRService;

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

	public static String GetRIMRForm(HttpServletRequest req) {
		String returnHtml = "<form id=\"RIMRForm\" action=\"javascript:void(0);\" onsubmit=\"createRIMRForm()\">";
		returnHtml = returnHtml + "Enter the Amount you wish to be Reimbursed <br><input type=\"number\" name=\"Amount\"><br>";
		returnHtml = returnHtml + "<input type =\"submit\" value=\"go\"></form>";		
		return returnHtml;
	}

	public static String CreateRimR(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int employee_id = (int) session.getAttribute("employeeid");
		int amount = Integer.parseInt(req.getParameter("Amount"));
		Date date_submitted = new Date(Calendar.getInstance().getTime().getTime());
		
		RIMRService.getRIMRService().addRIMR(amount, date_submitted, employee_id);
		return ViewPendingRequests(req);
	}

	public static String ViewPendingRequests(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int employee_id = (int) session.getAttribute("employeeid");
		List<RIMR> requests = new ArrayList<RIMR>();
		requests = RIMRService.getRIMRService().viewPendingRequests(employee_id);
		
		String returnHtml = "<table><thead><th>Request ID</th><th>Amount</th><th>Date Submitted</th><th>Status</th></thead><tbody>";
		
		for (RIMR rimr : requests) {
			returnHtml = returnHtml + "<tr><td>"+ rimr.getReimbursementrequest_id() +"</td>";
			returnHtml = returnHtml + "<td>$ "+ rimr.getAmount() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getDate_submitted() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getStatus() +"</td></tr>";
			
		}
		returnHtml = returnHtml + "</tbody></table>";
		
		return returnHtml;
	}

	public static String ViewResolvedRIMR(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int employee_id = (int) session.getAttribute("employeeid");
		List<RIMR> requests = new ArrayList<RIMR>();
		requests = RIMRService.getRIMRService().viewResolvedRequests(employee_id);
		
		String returnHtml = "<table><thead><th>Request ID</th><th>Amount</th><th>Date Submitted</th><th>Status</th><th>Manager Name</th><th>Date Resolved</th></thead><tbody>";
		
		for (RIMR rimr : requests) {
			returnHtml = returnHtml + "<tr><td>"+ rimr.getReimbursementrequest_id() +"</td>";
			returnHtml = returnHtml + "<td>$ "+ rimr.getAmount() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getDate_submitted() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getStatus() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getManagerFirstName() + " " + rimr.getManagerLastName() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getDate_resolved() +"</td></tr>";
			
		}
		returnHtml = returnHtml + "</tbody></table>";
		
		return returnHtml;
	}

	public static String ViewAllPendingRIMR(HttpServletRequest req) {
		List<RIMR> requests = new ArrayList<RIMR>();
		requests = RIMRService.getRIMRService().viewAllPendingRIMR();
		
		String returnHtml = "<table><thead><th>Request ID</th><th>Employee Name</th><th>Amount</th><th>Date Submitted</th></thead><tbody>";
		int i = 1;
		for (RIMR rimr : requests) {
			returnHtml = returnHtml + "<tr><td id=\"rimr"+i+"\">"+ rimr.getReimbursementrequest_id() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getEmployeeFrirstName() + " " + rimr.getEmployeeLastName() +"</td>";
			returnHtml = returnHtml + "<td>$ "+ rimr.getAmount() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getDate_submitted() +"</td>";
			returnHtml = returnHtml + "<td>"+ "<button onclick=\"AppoveRIMR(rimr"+i+")\">Approve</button><button onclick=\"RejectRIMR(rimr"+i+")\">Reject</button>" + "</td></tr>";
			i++;
			
		}
		returnHtml = returnHtml + "</tbody></table>";
		
		return returnHtml;
	}

	public static String ViewAllResolvedRIMR(HttpServletRequest req) {
		List<RIMR> requests = new ArrayList<RIMR>();
		requests = RIMRService.getRIMRService().viewAllResolvedRIMR();
		
		String returnHtml = "<table><thead><th>Request ID</th><th>Employee Name</th><th>Amount</th><th>Date Submitted</th><th>Status</th><th>Manager Name</th><th>Date Resolved</th></thead><tbody>";
		
		for (RIMR rimr : requests) {
			returnHtml = returnHtml + "<tr><td>"+ rimr.getReimbursementrequest_id() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getEmployeeFrirstName() + " " + rimr.getEmployeeLastName() +"</td>";
			returnHtml = returnHtml + "<td>$ "+ rimr.getAmount() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getDate_submitted() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getStatus() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getManagerFirstName() + " " + rimr.getManagerLastName() +"</td>";
			returnHtml = returnHtml + "<td>"+ rimr.getDate_resolved() +"</td></tr>";
			
		}
		returnHtml = returnHtml + "</tbody></table>";
		
		return returnHtml;
	}

	public static String ResolveRIMR(HttpServletRequest req, String decision) {
		HttpSession session = req.getSession();
		int rimr_id = Integer.parseInt(req.getParameter("RIMR_id"));
		Date date_resolved = new Date(Calendar.getInstance().getTime().getTime());
		int manager_id = (int) session.getAttribute("managerid");
		RIMRService.getRIMRService().ResolveRIMR(rimr_id, decision, date_resolved, manager_id );
		return ViewAllResolvedRIMR(req);
	}

	

}
 