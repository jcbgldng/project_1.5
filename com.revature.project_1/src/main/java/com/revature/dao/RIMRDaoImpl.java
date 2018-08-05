package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.connection.Jdbcconnection;
import com.revature.model.RIMR;

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

	public List<RIMR> viewPendingRequests(int employee_id) {
		Connection conn = null;
		try {
			conn = Jdbcconnection.getConnection();
			String sql = "select r.reimbursementrequest_id, e.first_name, e.last_name, r.amount, r.date_submitted, r.status from ReimbursementRequest r inner join employees e on r.employee_id = e.employee_id where r.status = 'Pending' and e.employee_id=?";
			
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			ResultSet rs = ps.executeQuery();
			
			List<RIMR> requests = new ArrayList<RIMR>();
			
			while(rs.next()) {
				requests.add(new RIMR(
						rs.getInt("reimbursementrequest_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("amount"),
						rs.getDate("date_submitted"),
						rs.getString("status"),
						null,
						null,
						null
						));
			}
			return requests;
			
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<RIMR> viewResolvedRequests(int employee_id) {
		Connection conn = null;
		try {
			conn = Jdbcconnection.getConnection();
			String sql = "select r.reimbursementrequest_id, e.first_name as efirst_name, e.last_name as elast_name, r.amount, r.date_submitted, r.status, m.first_name as mfirst_name, m.last_name as mlast_name, r.date_resolved from ReimbursementRequest r inner join employees e on r.employee_id = e.employee_id inner join managers m on r.manager_id = m.manager_id where r.status != 'Pending' and e.employee_id=?" + 
					"";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			ResultSet rs = ps.executeQuery();
			
			List<RIMR> requests = new ArrayList<RIMR>();
			
			while(rs.next()) {
				
				requests.add(new RIMR(
						rs.getInt("reimbursementrequest_id"),
						rs.getString("efirst_name"),
						rs.getString("elast_name"),
						rs.getInt("amount"),
						rs.getDate("date_submitted"),
						rs.getString("status"),
						rs.getString("mfirst_name"),
						rs.getString("mlast_name"),
						rs.getDate("date_resolved")
						));
			}
			return requests;
			
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RIMR> viewRequests(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RIMR> viewAllPendingRIMR() {
		Connection conn = null;
		try {
			conn = Jdbcconnection.getConnection();
			String sql = "select r.reimbursementrequest_id, e.first_name, e.last_name, r.amount, r.date_submitted, r.status from ReimbursementRequest r inner join employees e on r.employee_id = e.employee_id where r.status = 'Pending'";
			
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<RIMR> requests = new ArrayList<RIMR>();
			
			while(rs.next()) {
				requests.add(new RIMR(
						rs.getInt("reimbursementrequest_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("amount"),
						rs.getDate("date_submitted"),
						rs.getString("status"),
						null,
						null,
						null
						));
			}
			return requests;
			
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	

}
