package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connection.Jdbcconnection;
import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl employeeDaoImpl;
	
	private EmployeeDaoImpl() {
		
	}

	public static EmployeeDaoImpl getEmployeeDao() {
		if(employeeDaoImpl == null)
			employeeDaoImpl = new EmployeeDaoImpl();
		return employeeDaoImpl;
	}
	
	@Override
	public Employee getEmployee(String username, String password) {
		Connection theConn = null;
		try {
			Employee possibleEmployee = null;
			theConn = Jdbcconnection.getConnection();
			
			String sql = "select * from employees where username=?";
			PreparedStatement ps = theConn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				possibleEmployee = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("username"), 
						rs.getString("thePassword"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("address"), 
						rs.getString("phone_number"), 
						rs.getString("email")
						);
			}
			if(password.equals(possibleEmployee.getPassword()))
				return possibleEmployee;
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

	@Override
	public List<Employee> getEmployees() {
		try {
			Connection conn = Jdbcconnection.getConnection();
			String sql = "SELECT * FROM employees";
			
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employeeList =  new ArrayList<Employee>();
			
			while(rs.next()) {
				employeeList.add(new Employee(
						rs.getInt("employee_id"), 
						rs.getString("username"), 
						rs.getString("thePassword"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("address"), 
						rs.getString("phone_number"), 
						rs.getString("email")
						));
			}
			return employeeList;

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
