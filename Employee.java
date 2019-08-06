
public class Employee {

	private int employeeAge = 0;
	private String employeeName = null;
	private float employeeSalray = 0;
	
	public Employee(String employeeName, int employeeAge, float employeeSalary)
	{
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
		this.employeeSalray = employeeSalary;
	}
	
	
	@Override
	public String toString() { 
	    return "\nName: '" + this.employeeName + "', ID: '" + this.employeeAge + "', address: '" + this.employeeSalray + "'";
	} 
	
	// getters and setters
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public float getEmployeeSalray() {
		return employeeSalray;
	}

	public void setEmployeeSalray(float employeeSalray) {
		this.employeeSalray = employeeSalray;
	}
	

	public int getEmployeeAge() {
		return employeeAge;
	}
	
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}



}
