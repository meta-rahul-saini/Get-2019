package employee;

/** this class represent linkedList and has methods to perform operation on list
 * @author Rahul
 *
 */
public class LinkedList {

	private EmployeeNode front = null;
	private EmployeeNode rear = null;
	private EmployeeNode prevOfRear = null;
	private int size = 0;
	
	/** function to add node in linkedList
	 * @param data, integer type data 
	 * @return, true if node added
	 */
	public boolean addNode(Employee employee) {

		if (front == null) {
			this.front = new EmployeeNode(employee);
			this.rear = this.front;
		} else {
			prevOfRear = this.rear;
			this.rear.next = new EmployeeNode(employee);
			this.rear = this.rear.next;
		}
		this.size++;
		return true;
	}
	

	/**
	 * shows current linkedList 
	 */
	public void showList() {
		EmployeeNode node = front;
		while (node != null) {
			node = node.next;
		}
	}
	
	// getters and setters
	public EmployeeNode getFront() {
		return front;
	}


	public void setFront(EmployeeNode front) {
		this.front = front;
	}


	public EmployeeNode getRear() {
		return rear;
	}


	public void setRear(EmployeeNode rear) {
		this.rear = rear;
	}


	public boolean isEmpty() {
		if(this.front == null)
			return true;
		else
			return false;
	}


	public int size() {
		return this.size;
	}
	
	public Employee get(int index)
	{
		EmployeeNode iterator = this.front;
		int iteratorIndex =0;
		while(iterator != null)
		{
			if(index == iteratorIndex)
			{
				return iterator.getEmployee();
			}
		}
		throw new AssertionError("Out of bound index");
	}

//	public static void main(String... args) {
//		LinkedList linkedList = new LinkedList();
//		linkedList.addNode(1);
//		linkedList.addNode(2);
//		linkedList.addNode(3);
//		linkedList.addNode(4);
//		linkedList.addNode(5);
//		linkedList.showList();
//		System.out.println("finish");
//
//		linkedList.showList();
//
//		 System.out.println("==========");
//
//		 linkedList.rear.next = linkedList.front;
//
//		System.out.println(linkedList.ifLoopExists());
//	}

}
