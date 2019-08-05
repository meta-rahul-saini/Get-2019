import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EmployeeList {
	
	
	/**we use this function to sort employees sort by naturlal order of employee id
	 * @param listOfEmployees
	 * @return list of employees sorted by natural order
	 */
	public List<Employee> sortByNaturalOrder(List <Employee> listOfEmployees)
	{
		Comparator<Employee> comparator = Comparator.comparing( employee -> (employee.getEmployeeID()));
		listOfEmployees.sort(comparator);
		return listOfEmployees;
	}
	
	/**sorts the employee by their name
	 * @param listOfEmployees
	 * @return
	 */
	public List<Employee> sortByEmployeeName(List<Employee> listOfEmployees)
	{
		Comparator<Employee> comparator = Comparator.comparing( employee -> (employee.getEmployeeName()));
		listOfEmployees.sort(comparator);
		return listOfEmployees;
	}
	
	
	
	/**sorts employee by their name
	 * @param listOfEmployees
	 * @return
	 */
	public List<Employee>  getUniqueEmployeesList(List<Employee> listOfEmployees)
	{
		Set<Employee> listOfUniqueEmployees = new LinkedHashSet<Employee>(listOfEmployees);
		return new ArrayList<Employee> (listOfUniqueEmployees);
	}

	public static void main(String[] args) {
		
		Employee e1 = new Employee(201, "Rahul Saini", "Jhotwara, Jaipur");
		Employee e2 = new Employee(202, "Raghuveer Sharma", "Jagatpura, Jaipur");
		Employee e3 = new Employee(202, "Rishab Kacchwaha", "Airforce Road, Jodhpur");
		Employee e4 = new Employee(204, "Pranjul Gupta", "Bus stand, Agra");
		Employee e5 = new Employee(205, "Pramod Kumar", "Ranchi");
		
		List <Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(e5);
		listOfEmployees.add(e3);
		listOfEmployees.add(e2);
		listOfEmployees.add(e4);
		listOfEmployees.add(e1);
		
		EmployeeList ed = new EmployeeList();
		
//		List listOfEmployeesSortedByNaturalOrder = ed.sortByNaturalOrder(listOfEmployees);
		List listOfEmployessSortedByEmployeeName = ed.sortByEmployeeName(listOfEmployees);
//		List listOfUniqueEmployees = ed.getUniqueEmployeesList(listOfEmployees);
		
//		System.out.println(listOfUniqueEmployees);
//		System.out.println("===============================");
		System.out.println(listOfEmployessSortedByEmployeeName);
		System.out.println("===============================");
//		System.out.println(listOfEmployessSortedByEmployeeName);
		
		System.out.println(" Finish");
	}

}
