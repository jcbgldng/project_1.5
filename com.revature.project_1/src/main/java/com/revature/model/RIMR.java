package com.revature.model;

import java.sql.Date;

public class RIMR {
	private int reimbursementrequest_id;
	private String employeeFrirstName;
	private String employeeLastName;
	private int amount;
	private Date date_submitted;
	private String status;
	private String managerFirstName;
	private String managerLastName;
	private Date date_resolved;
	
	public RIMR(int reimbursementrequest_id, String employeeFrirstName, String employeeLastName, int amount,
			Date date_submitted, String status, String managerFirstName, String managerLastName, Date date_resolved) {
		super();
		this.reimbursementrequest_id = reimbursementrequest_id;
		this.employeeFrirstName = employeeFrirstName;
		this.employeeLastName = employeeLastName;
		this.amount = amount;
		this.date_submitted = date_submitted;
		this.status = status;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.date_resolved = date_resolved;
	}

	public int getReimbursementrequest_id() {
		return reimbursementrequest_id;
	}

	public void setReimbursementrequest_id(int reimbursementrequest_id) {
		this.reimbursementrequest_id = reimbursementrequest_id;
	}

	public String getEmployeeFrirstName() {
		return employeeFrirstName;
	}

	public void setEmployeeFrirstName(String employeeFrirstName) {
		this.employeeFrirstName = employeeFrirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(Date date_submitted) {
		this.date_submitted = date_submitted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public Date getDate_resolved() {
		return date_resolved;
	}

	public void setDate_resolved(Date date_resolved) {
		this.date_resolved = date_resolved;
	}

	@Override
	public String toString() {
		return "RIMR [reimbursementrequest_id=" + reimbursementrequest_id + ", employeeFrirstName=" + employeeFrirstName
				+ ", employeeLastName=" + employeeLastName + ", amount=" + amount + ", date_submitted=" + date_submitted
				+ ", status=" + status + ", managerFirstName=" + managerFirstName + ", managerLastName="
				+ managerLastName + ", date_resolved=" + date_resolved + "]";
	}
	
	
	
	

}
