package com.revature.dao;

import java.sql.Date;

public interface RIMRDao {
	public void addRIMR(int amount, Date date_submitted, int employee_id);
}
