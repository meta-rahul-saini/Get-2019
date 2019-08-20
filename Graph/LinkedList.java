
/** this class represent linkedList and has methods to perform operation on list
 * @author Rahul
 *
 */
public class LinkedList {

	private GraphNode front = null;
	private GraphNode rear = null;
	private GraphNode prevOfRear = null;
	/** function to add node in linkedList
	 * @param data, integer type data 
	 * @return, true if node added
	 */
	public boolean addNode(int data, int weight) {
		if (front == null) {
			System.out.println("front initialized: " );
			this.front = new GraphNode(data, weight);
			this.rear = this.front;
		} else {
			prevOfRear = this.rear;
			this.rear.next = new GraphNode(data, weight);
			this.rear = this.rear.next;
		}
		return true;
	}
	

	/**
	 * shows current linkedList 
	 */
	public void showList() {
		GraphNode node = front;
		while (node != null) {
			System.out.print(node.getVertex() + " -> ");
			node = node.next;
		}
	}
	
	public void discardRearEdge()
	{
		GraphNode iterator = this.getFront(); 
		GraphNode prevOfIterator = null;
		System.out.println("iterator: " + iterator );
		while(iterator.next != null)
		{
			prevOfIterator = iterator;
			iterator = iterator.next;
			if(iterator.next == null)
			{
				prevOfIterator.next = null;
				this.rear = prevOfIterator;
			}
		}
		// discarding the last node and updating the rear node
		
	}

	/** function to detect loop in linkedList
	 * @return true if loop exists
	 */
	public boolean ifLoopExists() {
		GraphNode fastIterator = this.front;
		GraphNode slowIterator = this.front;
		int size = 0;
		while (fastIterator != null && fastIterator.next != null) {
			fastIterator = fastIterator.next.next;
			slowIterator = slowIterator.next;
			if (slowIterator == fastIterator)
				return true;
		}
		if (size == 0)
			throw new AssertionError("List is empty");
		return false;

	}
	

	/** function to check weather two linkedList are equal or not
	 * @param linkedList2
	 * @return, true if lists are equal o/w false is returned
	 */
	public boolean isEqual(LinkedList linkedList2)
	{
		GraphNode iterator1 = this.front;
		GraphNode iterator2 = linkedList2.front;
		while(iterator1 != null)
		{
			if(iterator1.getVertex() != iterator2.getVertex())
				return false;
			iterator1 = iterator1.next;
			iterator2 = iterator2.next;
		}
		if(iterator1 != iterator2)
			return false;
		else
			return true;
	}
	
	// getters and setters
	public GraphNode getFront() {
		return this.front;
	}


	public void setFront(GraphNode front) {
		this.front = front;
	}


	public GraphNode getRear() {
		return rear;
	}


	public void setRear(GraphNode rear) {
		this.rear = rear;
	}
	
	public GraphNode getPrevOfRear() {
		return prevOfRear;
	}


	public void setPrevOfRear(GraphNode prevOfRear) {
		this.prevOfRear = prevOfRear;
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
