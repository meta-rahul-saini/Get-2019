import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * this class has test functions for testing the function of employeeList class
 */
public class EmployeeListTest {

	@Test
	public void sortByNaturalOrder_employeeList_sortedByEmployeeID()
	{
		Employee e1 = new Employee(201, "Rahul Saini", "Jhotwara, Jaipur");
		Employee e2 = new Employee(202, "Raghuveer Sharma", "Jagatpura, Jaipur");
		Employee e3 = new Employee(203, "Rishab Kacchwaha", "Airforce Road, Jodhpur");
		Employee e4 = new Employee(204, "Pranjul Gupta", "Bus stand, Agra");
		Employee e5 = new Employee(205, "Pramod Kumar", "Ranchi");
		
		List <Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(e5);
		listOfEmployees.add(e3);
		listOfEmployees.add(e2);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		

		EmployeeList ed = new EmployeeList();
		
		List<Employee> listOfEmployeesSortedByNaturalOrder = ed.sortByNaturalOrder(listOfEmployees);
		
		int expectedOutput[] = { 201, 202, 203, 204, 205};
		
		int computedOutput[] = new int[5];
		
		for (int index = 0; index < computedOutput.length; index++) {
			computedOutput[index] = listOfEmployeesSortedByNaturalOrder.get(index).getEmployeeID();
		}
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void sortByNaturalOrder_employeeList_sortedByEmployeeName()
	{
		Employee e1 = new Employee(201, "Rahul Saini", "Jhotwara, Jaipur");
		Employee e2 = new Employee(202, "Raghuveer Sharma", "Jagatpura, Jaipur");
		Employee e3 = new Employee(203, "Rishab Kacchwaha", "Airforce Road, Jodhpur");
		Employee e4 = new Employee(204, "Pranjul Gupta", "Bus stand, Agra");
		Employee e5 = new Employee(205, "Pramod Kumar", "Ranchi");
		
		List <Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(e5);
		listOfEmployees.add(e3);
		listOfEmployees.add(e2);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		

		EmployeeList ed = new EmployeeList();
		
		List<Employee> listOfEmployeesSortedByNaturalOrder = ed.sortByEmployeeName(listOfEmployees);
		
		String expectedOutput[] = {"Pramod Kumar", "Pranjul Gupta", "Raghuveer Sharma", "Rahul Saini", "Rishab Kacchwaha"};
		
		String computedOutput[] = new String[5];
		
		for (int index = 0; index < computedOutput.length; index++) {
			computedOutput[index] = listOfEmployeesSortedByNaturalOrder.get(index).getEmployeeName();
		}
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void sortByNaturalOrder_employeeList_uniqueEmployeeList()
	{
		Employee e1 = new Employee(201, "Rahul Saini", "Jhotwara, Jaipur");
		Employee e3 = new Employee(203, "Rishab Kacchwaha", "Airforce Road, Jodhpur");
		Employee e4 = new Employee(204, "Pranjul Gupta", "Bus stand, Agra");
		Employee e5 = new Employee(205, "Pramod Kumar", "Ranchi");
		
		List <Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(e5);
		listOfEmployees.add(e3);
		listOfEmployees.add(e3);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		

		EmployeeList ed = new EmployeeList();
		
		List<Employee> listOfEmployeesSortedByNaturalOrder = ed.getUniqueEmployeesList(listOfEmployees);
		
		int expectedOutput[] = {205, 203, 204, 201};
		
		int computedOutput[] = new int[4];
		
		for (int index = 0; index < computedOutput.length; index++) {
			computedOutput[index] = listOfEmployeesSortedByNaturalOrder.get(index).getEmployeeID();
		}
		assertArrayEquals(expectedOutput, computedOutput);
	}
}
