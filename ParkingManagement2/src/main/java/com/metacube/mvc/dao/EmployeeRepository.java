package com.metacube.mvc.dao;


import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.metacube.mvc.mapper.EmployeeMapper;
import com.metacube.mvc.mapper.FriendMapper;
import com.metacube.mvc.mapper.VehicleMapper;
import com.metacube.mvc.model.Employee;
import com.metacube.mvc.model.Vehicle;

@Repository
@SessionAttributes("EmployeeId")
public class EmployeeRepository {

	private Employee employee = new Employee();
	
	/**
	 * we are autowiring jdbc template 
	 * using the properties we have 
	 * 
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**function to save / insert employee in db
	 * @param employee
	 * @return employeeId 
	 */
	public int saveEmployee(Employee employee) {
		
		// inserting employee in db
		String insertQuery = "insert into employee values (null, ?, ?, ?, ?, ?, ?,DEFAULT); ";
		Object[] params = new Object[] {employee.getFullName(), employee.getGender(),
					employee.getEmail(),employee.getPassword(), employee.getContactNumber(),
					employee.getOrganization()};
		
		System.out.println("Full Name: " + employee.getFullName());
		
		System.out.println("jdbcTemplate: " + jdbcTemplate);
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        int row = jdbcTemplate.update(insertQuery, params, types);
        System.out.println(row + " row inserted.");
        
        // fetching employee id of inserted employee
        List<Integer> employeeList = jdbcTemplate.queryForList("select empId from employee where email = '" + employee.getEmail() + "'", Integer.class);
       
       return employeeList.get(0);
	}
	
	
	/**function to save vehicle in db
	 * @param vehicle
	 * @return
	 */
	public int saveVehicle(Vehicle vehicle)
	{
		// inserting employee in db
		String insertQuery = "insert into vehicle values (null, ?, ?, ?, ?, ?); ";

		Object[] params = new Object[] {vehicle.getVehicleName(), vehicle.getVehicleType(),
					vehicle.getVehicleNumber(),vehicle.getEmployeeId(), vehicle.getIdentification() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
		
		int row = jdbcTemplate.update(insertQuery, params, types);
		
		// fetching employee id of inserted employee
        List<Integer> vehicleIdList = jdbcTemplate.queryForList("select vehicleId from vehicle where vehicleNumber = '" + vehicle.getVehicleNumber() + "'", Integer.class);
       
		return vehicleIdList.get(0);
	}

	/**function to return price list from database using vehicle type
	 * @param vehicleType
	 * @return
	 */
	public Map getPriceList(@SessionAttribute("vehicleType") String vehicleType)
	{
        Map priceMap = jdbcTemplate.queryForMap("select * from priceList where vehicleType = '" + vehicleType + "'");
        return priceMap;
	}

	/**function to save pass details owned by owner
	 * @param empId
	 * @param vehicleId
	 * @param plan
	 * @param amount
	 */
	public void savePassDetail(Integer empId, Integer vehicleId, String plan, String amount) {
		

		System.out.println("empID: " + empId + "  vehicleId: " + vehicleId + "  amount: " + amount  + "  plan: " + plan);
		
		String insertQuery = "insert into PassDetail values(null, ?, ?, ?, ?, now()); ";
		Object[] params = new Object[] {empId, vehicleId, amount, plan, };
		
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.FLOAT, Types.VARCHAR};
	     
		int row = jdbcTemplate.update(insertQuery, params, types);
		
		System.out.println("vehicle row inserted: " + row);
		
	}

	/**function to check weather the user login is valid or not
	 * @param email
	 * @param password
	 * @return
	 */
	public int isValid(String email, String password) {
		
		 // fetching employee id of inserted employee
        List<Integer> vehicleIdList = jdbcTemplate.queryForList("select empId from employee where email = '" + email + "' and password='" + password + "';", Integer.class);
       
        if(vehicleIdList.size() != 0)
        	return vehicleIdList.get(0);
        else
        	return -1;
	}

	/**function to fetch users friends list already stored in db
	 * @param empId
	 * @return
	 */
	public List<Employee> getFriendsList(int empId) {
		
		 List<Employee> FriendsList = jdbcTemplate.query( 
				 "select * from employee where empId in (select friendId from FriendsList where empId = " + empId + ");",
				 new FriendMapper());   
	     
		 return FriendsList;
	}



	/**function to fetch employee profile by using employee id
	 * @param empId
	 * @return
	 */
	public Employee getEmployeeProfile(int empId) {
		
		List<Employee> employeeList = jdbcTemplate.query( 
				 "select * from employee where empId = " + empId + ";",
				 new EmployeeMapper());
		System.out.println("fullname: " + employeeList.get(0).getFullName() + " empId: " + employeeList.get(0).getEmpId());
		
		employee.setEmpId(employeeList.get(0).getEmpId());
		employee.setFullName(employeeList.get(0).getFullName());
		employee.setEmail(employeeList.get(0).getEmail());
		employee.setPassword(employeeList.get(0).getPassword());
		employee.setProfile(employeeList.get(0).getProfile());
		employee.setContactNumber(employeeList.get(0).getContactNumber());
		return employee;
	}

	
	/**	function to find return vehicle list for a particular employee
	 * @param empId
	 * @return
	 */
	public List getVehicleList(int empId) {
		List<Vehicle> vehicleList = jdbcTemplate.query( 
				 "select * from vehicle where empId = " + empId + ";",
				 new VehicleMapper());

		return vehicleList;
	}
	
	
	/**update employee profile
	 * @param employee
	 * @return
	 */
	public int updateProfile(Employee employee) {

		System.out.println("empID: " + employee.getEmpId() + "  fullName: " + employee.getFullName());
		
		String insertQuery = "update employee set fullName = ?, gender = ?,  email = ?, password = ?, contactNumber = ?, organization = ? where empId = ?;";
		
		Object[] params = new Object[] {employee.getFullName(), employee.getGender(), employee.getEmail(),
				 	employee.getPassword(), employee.getContactNumber(),
				 	employee.getOrganization(), employee.getEmpId()};
		
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.BIGINT, Types.VARCHAR, Types.INTEGER};
	     
		int row = jdbcTemplate.update(insertQuery, params, types);
		
		System.out.println("vehicle row updated: " + row);
		
		return row;
	}

	
	/**function to update image to an employee
	 * @param employeeId
	 * @param fileName
	 * @return
	 */
	public int  addImage(int employeeId, String fileName) {
		
		String insertQuery = "update employee set profile = '" + fileName + "';"  ;
			
		int row = jdbcTemplate.update(insertQuery);
		return row;
	}

	/**function to return coworkers list
	 * @param empId
	 * @return
	 */
	public List<Employee> getCoworkerssList(int empId) {

		 List<Employee> coworkersList = jdbcTemplate.query( 
				 "select * from employee where empId != " + empId,
				 new FriendMapper());   
		 return coworkersList;
	}

}
