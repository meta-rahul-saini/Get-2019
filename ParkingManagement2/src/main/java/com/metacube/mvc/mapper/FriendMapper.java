package com.metacube.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.mvc.model.Employee;

/**mapper class to map friend class
 * @author Rahul
 *
 */
public class FriendMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		
		employee.setFullName(rs.getString("fullName"));
		employee.setEmpId(rs.getInt("empId"));
		employee.setEmail(rs.getString("email"));
		employee.setContactNumber(rs.getString("contactNumber"));
		
		return employee;
	}

}
