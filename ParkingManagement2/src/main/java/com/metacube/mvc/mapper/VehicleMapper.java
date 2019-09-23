package com.metacube.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.mvc.model.Vehicle;


/**vehicle mapper class
 * @author Rahul
 *
 */
public class VehicleMapper implements RowMapper<Vehicle>
{
	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Vehicle vehicle = new Vehicle();
		
		vehicle.setVehicleId(Integer.parseInt(rs.getString("vehicleId")));
		vehicle.setVehicleName(rs.getString("vehicleName"));
		vehicle.setVehicleType(rs.getString("vehicleType"));
		vehicle.setVehicleNumber(rs.getString("vehicleNumber"));
		vehicle.setEmployeeId(Integer.parseInt(rs.getString("empId")));
		vehicle.setIdentification(rs.getString("identification"));
		return vehicle;
	}
}
