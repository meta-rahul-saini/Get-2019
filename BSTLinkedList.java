
/** this class represent linkedList and has methods to perform operation on list
 * @author Rahul
 *
 */
public class BSTLinkedList {

	private BSTLinkedListNode front = null;
	private BSTLinkedListNode rear = null;

	/** function to add node in linkedList
	 * @param data, integer type data 
	 * @return, true if node added
	 */
	public boolean addNode(String data) {

		if (front == null) {
			this.front = new BSTLinkedListNode(data);
			this.rear = this.front;
		} else {
			this.rear.next = new BSTLinkedListNode(data);
			this.rear = this.rear.next;
		}
		return true;
	}
	
	/**function to display list
	 * @param list
	 */
	public void showList()
	{
		BSTLinkedListNode iterator = this.getFront();
		while(iterator != null)
		{
			System.out.print("  " + iterator.key);
		iterator = iterator.next;
		}
	}
	
	// getters and setters
	public BSTLinkedListNode getFront() {
		return front;
	}


	public void setFront(BSTLinkedListNode front) {
		this.front = front;
	}


	public BSTLinkedListNode getRear() {
		return rear;
	}


	public void setRear(BSTLinkedListNode rear) {
		this.rear = rear;
	}

}
