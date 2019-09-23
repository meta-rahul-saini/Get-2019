package com.metacube.mvc.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**POJO class to represent Vehicle 
 * @author Rahul
 *
 */
public class Vehicle {
	
	
	private int vehicleId ; 
	
	@NotBlank(message = "{blankVehicleName}")
	@Pattern(regexp="^[a-zA-Z0-9 ]{1,}", message = "{validVehicleName}")
	private String vehicleName;
	
	private String vehicleType;
	
	@NotBlank(message = "{blankVehicleNumber}")
	@Pattern(regexp="^[A-Z][A-Z]\\d\\d[A-Z][A-Z]\\d{4}$", message = "{validVehicleNumber}")
	private String vehicleNumber;
	
	private int employeeId;
	
	private String identification;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
