package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.connection.Jdbcconnection;
import com.revature.model.Manager;

public class ManagerDaoImpl implements ManagerDao{
	
	private static ManagerDaoImpl theManagerDao;
	
	private ManagerDaoImpl() {}
	
	public static ManagerDaoImpl getManagerDao() {
		if(theManagerDao == null)
			theManagerDao = new ManagerDaoImpl();
		return theManagerDao; 
	}

	@Override
	public Manager getManager(String username, String password) {
		Connection theConn = null;
		try {
			Manager possibleManager = null;
			theConn = Jdbcconnection.getConnection();
			
			String sql = "select * from managers where username=?";
			PreparedStatement ps = theConn.prepareStatement(sql);
			
			ps.setString(1, username);
		
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				possibleManager = new Manager(
						rs.getInt("manager_id"), 
						rs.getString("username"), 
						rs.getString("thePassword"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("address"), 
						rs.getString("phone_number"), 
						rs.getString("email")
						);
			}
			if(password.equals(possibleManager.getPassword()))
				return possibleManager;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				theConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
