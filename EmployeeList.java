
/**
 *employee list class
 */
public class EmployeeList {
		
		private EmployeeNode front = null;
		private EmployeeNode rear = null;
		
		// points to the front of sortedList
		
		EmployeeNode startOfSortedList = null;
		
		/** function to add node in linkedList
		 * @param data, integer type data 
		 * @return, true if node added
		 */
		public boolean addNode(Employee data) {

			if (this.front == null) {
				this.front = new EmployeeNode(data);
				this.rear = this.front;
				this.rear.next= null;
			} else {
				this.rear.next = new EmployeeNode(data);
				this.rear = this.rear.next;
				this.rear.next = null;
			}
			return true;
		}
		

		/**
		 * shows current linkedList 
		 */
		public void showList(EmployeeNode front) {
			EmployeeNode node = front;
			while (node != null) {
				System.out.print(node.getData() + " -> ");
				node = node.next;
			}
		}

		// getters and setters
		
		public EmployeeNode sortBySalary()
		{
			EmployeeNode iterator = this.front;
			EmployeeNode SortedListFront = null;
			EmployeeNode node = null;
			
			// if  start is null simply return null;
			if(iterator == null)
			{
				return null;
			}
			
			// else find the node in list and simply insertion sort into a new list as follow
			while( iterator != null)
			{
				node =  new EmployeeNode(iterator.getData());
				SortedListFront = insertInSortedList(node);
				iterator = iterator.next;
			}
			
			// reference to the start node of sorted list
			return SortedListFront;
		}
		
		/** function to insert employees into a list with descending sorting order of their salary
		 *	if two employee has same salary then greater salary employee come first
		 * @param node, node to be insert
		 * @return reference to the head node or sorted list
		 */
		public EmployeeNode insertInSortedList(EmployeeNode node)
		{
			// if sorted list is empty then we set the head of this list also the current node
			if(this.startOfSortedList == null)
			{	
				this.startOfSortedList = node;
				this.startOfSortedList.next = null;
			}
			else
			{
				EmployeeNode iterator  = startOfSortedList;
				EmployeeNode prevIterator = null;
				float salary1 = 0;
				float salary2 = 0;
				
				while( iterator != null && node.getData().getEmployeeSalray() <= iterator.getData().getEmployeeSalray())
				{
					salary1 = iterator.getData().getEmployeeSalray();
					salary2 = node.getData().getEmployeeSalray();
					
					if(Float.compare(salary1, salary2) == 0)
					{
						break;
					}
					else
					{
						prevIterator = iterator;
						iterator = iterator.next;
					}
						 
				}
				
				// if node have highest salary i.e. we have to insert at first node of the list
				if(prevIterator == null)
				{
					EmployeeNode temp = this.startOfSortedList;
					this.startOfSortedList = node;
					node.next = temp;
				}
				// if they have equal salary then we compare their age
				else if(Float.compare(salary1 , salary2) == 0)
				{
					if(iterator.getData().getEmployeeAge() > node.getData().getEmployeeAge())
					{
						prevIterator.next = node;
						node.next = iterator;
					}
					else if(prevIterator.getData().getEmployeeAge() < node.getData().getEmployeeAge())
					{
						node.next = iterator.next;
						iterator.next = node;
					}	
				}
				else
				{
				prevIterator.next = node;
				node.next = iterator;
				}
			}
			return this.startOfSortedList;
		}


		public static void main(String... args) {
			
			EmployeeList list = new EmployeeList();
			
			Employee e1 = new Employee("rahul", 21, 21000);
			Employee e2 = new Employee("rakesh", 22, 22200);
			Employee e3 = new Employee("ramesh", 24, 25500);
			Employee e4 = new Employee("mahesh", 21, 22200);

			list.addNode(e3);
			list.addNode(e2);
			list.addNode(e4);
			list.addNode(e1);
			System.out.println("==========");
			EmployeeNode sortedListFront = list.sortBySalary();;
		
			list.showList(sortedListFront);
		}
}
