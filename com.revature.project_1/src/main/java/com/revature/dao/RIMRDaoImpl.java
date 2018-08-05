package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.revature.connection.Jdbcconnection;

public class RIMRDaoImpl implements RIMRDao{
	
	static RIMRDaoImpl rimrDaoImpl = null;
	
	private RIMRDaoImpl() {
	}

	public static RIMRDaoImpl getRIMRDAO() {
		if(rimrDaoImpl == null)
			rimrDaoImpl = new RIMRDaoImpl();
		return rimrDaoImpl;
	}

	public void addRIMR(int amount, Date date_submitted, int employee_id) {
		Connection theConn = null;
		try {
			theConn = Jdbcconnection.getConnection();
			
			String sql = "call add_reimbursementrequest(?,?,?)";
			CallableStatement cs = theConn.prepareCall(sql);
			
			cs.setInt(1, amount);
			cs.setDate(2, date_submitted);
			cs.setInt(3, employee_id);
			cs.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}finally {
			try {
				theConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	

}
