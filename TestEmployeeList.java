import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**this class has test cases for methods in EmployeeList class
 * @author Rahul
 *
 */
public class TestEmployeeList {

	@Test
	public void testSortByNaturalOrderWhenUserPassesUniqueValue()
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

		System.out.println(listOfEmployeesSortedByNaturalOrder);
		
		Object[] computedOutput = listOfEmployeesSortedByNaturalOrder.toArray();
		
		System.out.println(computedOutput);
		
		Employee expectedOutput[] = {e1, e2, e3, e4, e5};
		
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void testSortByNaturalOrderWhenUserPassesDuplicateValue()
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
		listOfEmployees.add(e2);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		
		EmployeeList ed = new EmployeeList();
		List<Employee> listOfEmployeesSortedByNaturalOrder = ed.sortByNaturalOrder(listOfEmployees);

		System.out.println(listOfEmployeesSortedByNaturalOrder);
		
		Object[] computedOutput = listOfEmployeesSortedByNaturalOrder.toArray();
		
		System.out.println(computedOutput);
		
		Employee expectedOutput[] = {e1, e2, e2, e3, e4, e5};
		
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void testSortByEmployeeNameWhenUserPassesUniqueValue()
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
		List<Employee> listOfEmployeesSortedByEmplyeeName = ed.sortByEmployeeName(listOfEmployees);

		System.out.println(listOfEmployeesSortedByEmplyeeName);
		
		Object[] computedOutput = listOfEmployeesSortedByEmplyeeName.toArray();
		System.out.println("============");
		System.out.println(computedOutput);
		
		Employee expectedOutput[] = {e5, e4, e2, e1, e3};
		
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void testSortByEmployeeNameWhenUserPassesDuplicateValue()
	{
		Employee e1 = new Employee(201, "Rahul Saini", "Jhotwara, Jaipur");
		Employee e2 = new Employee(202, "Raghuveer Sharma", "Jagatpura, Jaipur");
		Employee e3 = new Employee(203, "Rishab Kacchwaha", "Airforce Road, Jodhpur");
		Employee e4 = new Employee(204, "Pranjul Gupta", "Bus stand, Agra");
		Employee e5 = new Employee(205, "Pramod Kumar", "Ranchi");
		Employee e6 = new Employee(206, "Pramod Kumar", "Jaipur");
		
		List <Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(e5);
		listOfEmployees.add(e3);
		listOfEmployees.add(e2);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		listOfEmployees.add(e6);
		
		EmployeeList ed = new EmployeeList();
		List<Employee> listOfEmployeesSortedByEmplyeeName = ed.sortByEmployeeName(listOfEmployees);

		System.out.println(listOfEmployeesSortedByEmplyeeName);
		
		Object[] computedOutput = listOfEmployeesSortedByEmplyeeName.toArray();
		
		System.out.println(computedOutput);
		
		Employee expectedOutput[] = {e5, e6, e4, e2, e1, e3};
		
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void testGetUniqueEmployeesList()
	{
		Employee e1 = new Employee(201, "Rahul Saini", "Jhotwara, Jaipur");
		Employee e2 = new Employee(202, "Raghuveer Sharma", "Jagatpura, Jaipur");
		Employee e3 = new Employee(203, "Rishab Kacchwaha", "Airforce Road, Jodhpur");
		Employee e4 = new Employee(204, "Pranjul Gupta", "Bus stand, Agra");
		Employee e5 = new Employee(205, "Pramod Kumar", "Ranchi");
		Employee e6 = new Employee(205, "Rakesh Soni", "Jaipur");
		
		
		
		List <Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(e5);
		listOfEmployees.add(e5);
		listOfEmployees.add(e3);
		listOfEmployees.add(e2);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		listOfEmployees.add(e6);
		
		EmployeeList employeeList = new EmployeeList();
		
		List<Employee> listOfUniqueEmployees = employeeList.getUniqueEmployeesList(listOfEmployees);
		
		Object[] computedOutput = listOfUniqueEmployees.toArray();
		
		Employee expectedOutput[] = {e5, e3, e2, e4, e1};
		
		System.out.println(listOfUniqueEmployees);
		
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	
}
