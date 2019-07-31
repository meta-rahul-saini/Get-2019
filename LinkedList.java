
/** this class represent linkedList and has methods to perform operation on list
 * @author Rahul
 *
 */
public class LinkedList {

	private Node front = null;
	
	/** function to add node in linkedList
	 * @param data, integer type data 
	 * @return, true if node added
	 */
	public boolean addNode(int data) {

		if (front == null) {
			this.front = new Node(data);
			this.rear = this.front;
		} else {
			this.rear.next = new Node(data);
			this.rear = this.rear.next;
		}
		return true;
	}
	

	/**
	 * shows current linkedList 
	 */
	public void showList() {
		Node node = front;
		while (node != null) {
			System.out.print(node.getData() + " -> ");
			node = node.next;
		}
	}

	/** function to rotate sublist clockwise
	 * @param L, specifies position of sublist in linkedlist
	 * @param R, specifies length of sublist
	 * @param N, specifies no. of rotations clockwise
	 * @return new linkedList where sublist is rotated N times clockwise.
	 */
	public LinkedList rotateSubList(int L, int R, int N) {
		
		// generate new linkedList 
		
		LinkedList linkedList1 = new LinkedList();
		
		Node node = front;
		Node rear = null;
		int distFromLeft = 0;
		int length = 0;
		Node sortedNode = null;
		
		int size = 0;
		Node ListItearator = this.front;

		// counting total no. of nodes
		while (ListItearator != null) {
			ListItearator = ListItearator.next;
			size++;
		}
		
		if(size == 0 || L > size) 
		{
			throw new AssertionError("please pass valid arguments");
		}
		
		if( (L + R) > size)
		{
			R = size - L + 1;
		}
		// generating sublist from currentList
		while (node != null) 
		{
			distFromLeft++;
			if (distFromLeft == L) 
			{
				while (length < R && node != null) 
				{
					System.out.println("inside while" + node.getData());
					linkedList1.addNode(node.getData());
					node = node.next;
					rear = node;
					length++;
				}
			}
			if (node != null) {
				node = node.next;
			}
		}

		// rotate sublist N times
		linkedList1 = linkedList1.rotate(N);

		node = null;

		// create a new linkedList
		LinkedList linkedList = new LinkedList();
		distFromLeft = 0;
		length = 0;
		node = this.front;
		sortedNode = linkedList1.front;
		System.out.println("front data: " + sortedNode.getData());
		
		// adding remaining elements of list to new list.
		while (node != null) 
		{
			distFromLeft++;
			if (distFromLeft == L) 
			{
				// adding rotated elements
				while (length < R && node != null) 
				{

					System.out.println("legth: " + length + "R: " + R
							+ "data: " + node.getData());
					linkedList.addNode(sortedNode.getData());
					sortedNode = sortedNode.next;
					node = node.next;
					length++;
				}
				// adding elements which are at position after the sublist
				node = rear;
				while (node != null) 
				{
					linkedList.addNode(node.getData());
					node = node.next;
				}
		} 
			// adding elements which are present before the sublist 
			else 
			{
				linkedList.addNode(node.getData());
			}
		}
		return linkedList;
	}

	/** function to rotate current LinkedList by N rotation
	 * @param N, no. of time to rotate clock-wise
	 * @return, rotated linkedList
	 */
	public LinkedList rotate(int N) {

		int size = 0;
		int nodeTraversed = 0;
		Node node = this.front;
		Node prevNode = null;

		// counting total no. of nodes
		while (node != null) {
			node = node.next;
			size++;
		}

		// actual rotation required is N % size, where size is length of sublist
		System.out.println("size: " + size);
		int rotationRequired = N % size;

		
		System.out.println("rotation required: " + rotationRequired);
		
		node = this.front;

		while (nodeTraversed < (size - rotationRequired)) 
		{
			prevNode = node;
			node = node.next;
			nodeTraversed++;
		}
		System.out.println("node traversed: " + nodeTraversed);

		Node temp = null;
		temp = front;
		front = node;
		rear.next = temp;
		prevNode.next = null;

		return this;
	}

	/** function to detect loop in linkedList
	 * @return true if loop exists
	 */
	public boolean ifLoopExists() {
		Node fastIterator = this.front;
		Node slowIterator = this.front;
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
		Node iterator1 = this.front;
		Node iterator2 = linkedList2.front;
		while(iterator1 != null)
		{
			if(iterator1.getData() != iterator2.getData())
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
	public Node getFront() {
		return front;
	}


	public void setFront(Node front) {
		this.front = front;
	}


	public Node getRear() {
		return rear;
	}


	public void setRear(Node rear) {
		this.rear = rear;
	}

	private Node rear = null;

	public static void main(String... args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		linkedList.showList();
		System.out.println("finish");

		LinkedList list = linkedList.rotateSubList(1, 5, 2);

		list.showList();

		 System.out.println("==========");

		 linkedList.rear.next = linkedList.front;

		System.out.println(linkedList.ifLoopExists());
	}

}
