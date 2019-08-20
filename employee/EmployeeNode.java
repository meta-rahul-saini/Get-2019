package employee;

public class EmployeeNode {

	Employee employee;
	EmployeeNode prev = null;
	EmployeeNode next = null;
	
	EmployeeNode(Employee employee){
		this.employee = employee;
	}
		// getters and setters
		public Employee getEmployee(){
			return this.employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
}


