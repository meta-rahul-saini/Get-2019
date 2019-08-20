package employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *this class has test cases for quick sort of employeelist
 */
public class EmployeeListTest {

	@Test
	public void quickSortBySalary_EmployeeList_sortedEmployeeList()
	{
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.insert(101, "rahul", 16000, "1-2-1997");
		employeeList.insert(102, "ramesh", 160, "1-2-1987");
		employeeList.insert(105, "rakesh", 10, "1-2-1997");
		employeeList.insert(106, "mahesh", 60, "1-2-1998");
		employeeList.insert(107, "rajesh", 1600, "1-2-1997");
		employeeList.insert(108, "mukesh", 1600, "1-2-1999");
		employeeList.insert(103, "mahesh", 1600, "1-2-1998");
		employeeList.insert(109, "ritesh", 1060, "1-2-1995");
		employeeList.insert(110, "hitesh", 15000, "1-2-1997");
		employeeList.quickSortBySalary(employeeList.start, employeeList.end);
		employeeList.print();
		
		List <Integer> computedOutputList = new ArrayList<Integer>();
		EmployeeNode iterator = employeeList.start;
		while(iterator != null)
		{
			computedOutputList.add(iterator.getEmployee().empId);
			iterator = iterator.next;	
		}
		System.out.println(computedOutputList);
		List <Integer> expectedOutputList = new ArrayList<Integer>();
		
		expectedOutputList.add(101);
		expectedOutputList.add(110);
		expectedOutputList.add(108);
		expectedOutputList.add(103);
		expectedOutputList.add(107);
		expectedOutputList.add(109);
		expectedOutputList.add(102);
		expectedOutputList.add(106);
		expectedOutputList.add(105);
		
		assertEquals(true, expectedOutputList.equals(computedOutputList));
	}
}
