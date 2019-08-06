
public class EmployeeNode {

	Employee data = null;
	EmployeeNode next = null;
	
	public EmployeeNode(Employee data) {
		this.data = data;
	}

	// getters and setters
	public EmployeeNode getNext() {
		return next;
	}

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}

	public void setNext(EmployeeNode next) {
		this.next = next;
	}

	
}
