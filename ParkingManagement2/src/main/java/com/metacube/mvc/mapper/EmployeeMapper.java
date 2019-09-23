package com.metacube.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.mvc.model.Employee;

/**Mapper class used by by jdbctemplate to Mapping data to Employee
 * @author Rahul
 *
 */
public class EmployeeMapper implements RowMapper<Employee>  {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		
		employee.setEmpId(rs.getInt("empId"));
		employee.setFullName(rs.getString("fullName"));
		employee.setGender(rs.getString("gender"));
		employee.setEmail(rs.getString("email"));
		employee.setPassword(rs.getString("password"));
		employee.setContactNumber(rs.getString("contactNumber"));
		employee.setProfile(rs.getString("profile"));
		employee.setOrganization(rs.getString("organization"));
		
		return employee;
	}

}
