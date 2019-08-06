import org.junit.Test;
import static org.junit.Assert.*;
/**this class has test cases for testing the methods of employeeTest class
 *
 */
public class EmployeeTestClass {

	@Test
	public void insertionSort_UnsortedBySalaryData_DescendingOrderSortedData()
	{
	EmployeeList list = new EmployeeList();
	
	Employee e1 = new Employee("rahul", 21, 21000);
	Employee e2 = new Employee("rakesh", 22, 23200);
	Employee e3 = new Employee("ramesh", 24, 25500);
	Employee e4 = new Employee("mahesh", 21, 22200);

	list.addNode(e3);
	list.addNode(e2);

	list.addNode(e1);
	list.addNode(e4);
	
	EmployeeNode sortedListFront = list.sortBySalary();;
	
	int expectedAge[] = {24, 22, 21, 21};
						
	int computedAge[] = new int[4];

	int expectedSalary[] = {25500, 23200, 22200, 21000};

	int computedSalary[] = new int[4];
	
	EmployeeNode iterator = sortedListFront;
	
	int i = 0;
	while(iterator != null)
	{
		computedAge[i] = iterator.getData().getEmployeeAge();
		computedSalary[i] = (int)iterator.getData().getEmployeeSalray();
		iterator = iterator.next;
		i++;
	}
		
	
	list.showList(sortedListFront);
	assertArrayEquals(expectedAge, computedAge);
	assertArrayEquals(expectedSalary, computedSalary);
		
	}
	
	@Test
	public void insertionSort_WhenTieBtSalaryData_OrderedByAgeData()
	{
	EmployeeList list = new EmployeeList();
	
	Employee e1 = new Employee("rahul", 21, 21000);
	Employee e2 = new Employee("rakesh", 22, 22200);
	Employee e3 = new Employee("ramesh", 24, 25500);
	Employee e4 = new Employee("mahesh", 21, 22200);

	list.addNode(e3);
	list.addNode(e2);

	list.addNode(e1);
	list.addNode(e4);
	
	EmployeeNode sortedListFront = list.sortBySalary();;
	
	int expectedAge[] = {24, 21, 22, 21};
						
	int computedAge[] = new int[4];

	int expectedSalary[] = {25500, 22200, 22200, 21000};

	int computedSalary[] = new int[4];
	
	EmployeeNode iterator = sortedListFront;
	
	int i = 0;
	while(iterator != null)
	{
		computedAge[i] = iterator.getData().getEmployeeAge();
		computedSalary[i] = (int)iterator.getData().getEmployeeSalray();
		iterator = iterator.next;
		i++;
	}
		
	
	list.showList(sortedListFront);
	assertArrayEquals(expectedAge, computedAge);
	assertArrayEquals(expectedSalary, computedSalary);
		
	}
}
