package employee;

public class EmployeeList {
	EmployeeNode start = null, end = null;

	/**function to insert employee details in employee List
	 * @param id
	 * @param name
	 * @param salary
	 * @param dob
	 */
	public void insert(int id, String name, int salary, String dob) {
		Employee newEmployee = new Employee(id, name, salary, dob);
		EmployeeNode newEmployeeNode = new EmployeeNode(newEmployee);
		if (start == null) 
		{
			start = newEmployeeNode;
			end = start;
		} else 
		{
			EmployeeNode currNode = start;
			while (currNode.next != null) 
			{
				currNode = currNode.next;
			}
			currNode.next = newEmployeeNode;
			end = newEmployeeNode;
		}
	}

	/**returns the rear node
	 * @param node
	 * @return
	 */
	public EmployeeNode getEnd(EmployeeNode node)
	{
		while (node != null && node.next != null) 
		{
			node = node.next;
		}
		return node;
	}

	/**this method generate partition of employee and generates reference to the pivot node
	 * @param low
	 * @param high
	 * @return
	 */
	public EmployeeNode partition(EmployeeNode low, EmployeeNode high)
	{
		
		int pivotSalary = high.getEmployee().getSalary(); 
		EmployeeNode iterator1 = low.prev; 
		
		for(EmployeeNode iterator2=low; iterator2!=high; iterator2=iterator2.next)
		{
			if(iterator2.getEmployee().getSalary() >= pivotSalary)
			{ 
				if( iterator1 == null)
				{
					iterator1 = low;
				}
				else
				{
					iterator1 = iterator1.next;
				}
				// Similar to i++ 
	            //System.out.println(j.next.emp.getSalary());
				
				// swap elements
	            int tempSalary = iterator1.getEmployee().getSalary();
	            int tempId = iterator1.getEmployee().getEmpId();
	            String tempName = iterator1.getEmployee().getName();
	            String tempDob = iterator1.getEmployee().getdob();
	            
	            iterator1.getEmployee().salary = iterator2.getEmployee().getSalary();
	            iterator1.getEmployee().dob = iterator2.getEmployee().getdob();
	            iterator1.getEmployee().empId = iterator2.getEmployee().getEmpId();
	            iterator1.getEmployee().name = iterator2.getEmployee().getName();
	            
	            iterator2.getEmployee().salary = tempSalary;
	            iterator2.getEmployee().dob = tempDob;
	            iterator2.getEmployee().empId = tempId;
	            iterator2.getEmployee().name = tempName;
	        }
       }
		
		if(iterator1== null)
		{
			iterator1= low;
		}
		else
		{
			iterator1= iterator1.next;
		}
    
		// swap elements
        int tempSalary = iterator1.getEmployee().getSalary();
        int tempId = iterator1.getEmployee().getEmpId();
        String tempName = iterator1.getEmployee().getName();
        String tempDob = iterator1.getEmployee().getdob();
        
        iterator1.getEmployee().salary = high.getEmployee().getSalary();
        iterator1.getEmployee().dob = high.getEmployee().getdob();
        iterator1.getEmployee().empId = high.getEmployee().getEmpId();
        iterator1.getEmployee().name = high.getEmployee().getName();
        
        high.getEmployee().salary = tempSalary;
        high.getEmployee().dob = tempDob;
        high.getEmployee().empId = tempId;
        high.getEmployee().name = tempName;
    return iterator1;
		
	}

	/**function to implement quickSort
	 * @param low
	 * @param high
	 */
	public void quickSortBySalary(EmployeeNode low, EmployeeNode high) 
	{
		if(high != null && low != high && low != high.next)
		{ 
			EmployeeNode temp = partition(low,high); 
            quickSortBySalary(low,temp.prev); 
            quickSortBySalary(temp.next,high); 
            
            for(EmployeeNode iterator=low; iterator!=high; iterator=iterator.next)
            {
            	if(iterator != high && iterator.next.getEmployee().getSalary() == iterator.getEmployee().getSalary())
            	{
                	if(iterator.next.getEmployee().getBirthYear() > iterator.getEmployee().getBirthYear())
                	{
                		int tempSalary = iterator.next.getEmployee().getSalary();
                		int tempId1 = iterator.next.getEmployee().getEmpId();
                        String tempName1 = iterator.next.getEmployee().getName();
                        String tempDob1 = iterator.next.getEmployee().getdob();
                         
                        iterator.next.getEmployee().salary = iterator.getEmployee().getSalary();
                         iterator.next.getEmployee().dob = iterator.getEmployee().getdob();
                         iterator.next.getEmployee().empId = iterator.getEmployee().getEmpId();
                         iterator.next.getEmployee().name = iterator.getEmployee().getName();
                         
                         iterator.getEmployee().salary = tempSalary;
                         iterator.getEmployee().dob = tempDob1;
                         iterator.getEmployee().empId = tempId1;
                         iterator.getEmployee().name = tempName1;
                	}
            	}
            }
        } 
	}

	/**
	 * @param start
	 *            print all the employees sorted by (salary(DESC)>age(ASC))
	 */
	public  void print() 
	{
		EmployeeNode tempNode = this.start;
		while (tempNode != null) 
		{
			System.out.println(tempNode.getEmployee().getSalary() + " "
					+ tempNode.getEmployee().getBirthYear());
			tempNode = tempNode.next;
			if (tempNode == null) 
			{
				break;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) 
	{
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.insert(101, "rahul", 16000, "1-2-1997");
		employeeList.insert(102, "ramesh", 160, "1-2-1987");
		employeeList.insert(105, "rakesh", 10, "1-2-1997");
		employeeList.insert(106, "mahesh", 60, "1-2-1998");
		employeeList.insert(107, "rajesh", 1600, "1-2-1997");
		employeeList.insert(108, "mukesh", 1600, "1-2-1999");
		employeeList.insert(108, "mahesh", 1600, "1-2-1998");
		employeeList.insert(109, "ritesh", 1060, "1-2-1995");
		employeeList.insert(110, "hitesh", 15000, "1-2-1997");
		employeeList.quickSortBySalary(employeeList.start, employeeList.end);
		employeeList.print();
	}
}