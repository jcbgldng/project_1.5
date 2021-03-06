package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;

import com.revature.handler.EmployeeHandler;
import com.revature.handler.FirstNameHandler;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/com.revature.project_1/UserFisrtName.ajax":
			return FirstNameHandler.getFirstName(req);
		case "/com.revature.project_1/viewEmployees.ajax":
			return EmployeeHandler.getEmployees();
		case "/com.revature.project_1/ViewEmployeeInformation.ajax":
			return EmployeeHandler.getEmployeeInformation(req);
		case "/com.revature.project_1/GetChangeForm.ajax":
			return EmployeeHandler.GetChangeForm(req);
		case "/com.revature.project_1/UpdateEmployeeInformation.ajax":
			return EmployeeHandler.UpdateEmployeeInformation(req);
		case "/com.revature.project_1/GetRIMRForm.ajax":
			return EmployeeHandler.GetRIMRForm(req);
		case "/com.revature.project_1/CreateRimR.ajax":
			return EmployeeHandler.CreateRimR(req);
		case "/com.revature.project_1/PendingRIMR.ajax":
			return EmployeeHandler.ViewPendingRequests(req);
		case "/com.revature.project_1/ResolvedRIMR.ajax":
			return EmployeeHandler.ViewResolvedRIMR(req);
		case "/com.revature.project_1/getAllPendingRIMR.ajax":
			return EmployeeHandler.ViewAllPendingRIMR(req);
		case "/com.revature.project_1/getAllResolvedRIMR.ajax":
			return EmployeeHandler.ViewAllResolvedRIMR(req);
		case "/com.revature.project_1/appoveRIMR.ajax":
			return EmployeeHandler.ResolveRIMR(req, "Approved");
		case "/com.revature.project_1/rejectRIMR.ajax":
			return EmployeeHandler.ResolveRIMR(req, "Rejected");
		case "/com.revature.project_1/GetAllEmployeeRequests.ajax":
			return EmployeeHandler.GetAllEmployeeRequests(req);
		default :
			return " ";
		}
	}

}
