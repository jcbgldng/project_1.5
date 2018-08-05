package com.revature.dao;

import java.sql.CallableStatement;
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
		Connection conn = null;
		try {
			conn = Jdbcconnection.getConnection();
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
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Employee updateEmployee(int employee_id, String firstName, String lastName, String address, String phone,
			String email) {
		Connection theConn = null;
		try {
			Employee possibleEmployee = null;
			theConn = Jdbcconnection.getConnection();
			
			String sql = "call update_employee(?,?,?,?,?,?)";
			CallableStatement cs = theConn.prepareCall(sql);
			
			cs.setInt(1, employee_id);
			cs.setString(2, firstName);
			cs.setString(3, lastName);
			cs.setString(4, address);
			cs.setString(5, phone);
			cs.setString(6, email);
			cs.executeUpdate();
			
			sql = "SELECT * FROM employees where employee_id=?";
			
			PreparedStatement ps;
			ps = theConn.prepareStatement(sql);
			ps.setInt(1, employee_id);
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
			return possibleEmployee;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				theConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
