package com.revature.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.RIMR;

public interface RIMRDao {
	public void addRIMR(int amount, Date date_submitted, int employee_id);
	public List<RIMR> viewRequests(HttpServletRequest req);
	public List<RIMR> viewPendingRequests(int employee_id);
	public List<RIMR> viewResolvedRequests(int employee_id);
	public List<RIMR> viewAllPendingRIMR();
	public List<RIMR> viewAllResolvedRIMR();
}
