
/** we use this to perform our circular queue operations
 * @author Rahul
 *
 */
public class PriorityQueue {
	
	private int currentSize;
	private int queueSize;
	int[][] circularQueue;
	private int front;
	private int rear;
	
	/** constructor to initialize the parameters o priorityQueue
	 * @param queueSize
	 */
	public PriorityQueue(int queueSize)
	{
		this.queueSize = queueSize;
		this.circularQueue = new int[this.queueSize][2];
		this.currentSize = 0;
		this.front = -1;
		this.rear = -1;
	}
	
	/**function to insert an element with the given priority in priorityQueue
	 * @param data
	 * @param priority
	 */
	public void insert(int data, int priority)
	{
		//if queue is full throw assertion error with message
		if (isFull()) 
		{
			throw new AssertionError("Circular Queue is full. Element cannot be added");
		} 
		else 
		{	// if queue is empty 
			if(isEmpty()) 
			{
				this.front = (this.front + 1) % this.circularQueue.length;
				this.rear = this.front;
				this.circularQueue[this.front][0] = data;
				this.circularQueue[this.front][1] = priority;
				this.currentSize++;
			}
			
			//if priority is maximum then insert it to the first of first
			else if (circularQueue[front][1] < priority && !this.isFull()) 
			{
				this.show();
				
				shiftByOne(this.circularQueue, this.front, this.rear);

				this.rear = (this.rear + 1)%circularQueue.length;
				
				System.out.println(" ====> ater shifting <=====");

				this.show();
				
				this.circularQueue[0][0] = data;
				this.circularQueue[0][1] = priority;
				
				currentSize++;
			}
			// if priority is minimum then insert it after rear 
			else if (circularQueue[rear][1] > priority && !this.isFull()) {
				
				rear = (rear + 1) % circularQueue.length;
	            circularQueue[rear][0] = data;
	            circularQueue[rear][1] = priority;
	            currentSize++;
	            
			}
			// if priority is of middle value
			else {
				int iterator = front;
				
				while(priority <  circularQueue[iterator][1])
				{
					iterator = (iterator + 1)% circularQueue.length;
				}
				System.out.println(" itr: " + iterator);
				this.show();
				
				shiftByOne(circularQueue, iterator, rear);
				
				iterator  = (iterator + 1)% circularQueue.length;
				this.show();
				System.out.println("updating value: ");
				iterator--;
				circularQueue[iterator][0] = data;
	            circularQueue[iterator][1] = priority;
				currentSize++;
			}
		}
	}
	
	public void dequeue()
	{
		circularQueue[this.front][0]= 0;
	}
	/**
	 * Check if queue is full.
	 * @return true if queue is full o/w false is returned.
	 */
	public boolean isFull() {
		return (currentSize == circularQueue.length);
	}
	
	/**
	 * Check if Queue is empty. @return, true if queue is empty o/w false is
	 * returned
	 */
	public boolean isEmpty() {
		return (currentSize == 0);
	}
	
	/**function used to shift elements the array by one
	 * @param arr, array of elements
	 * @param start start index 
	 * @param end1 , end index
	 */
	public void shiftByOne(int[][] arr, int start, int end)
	{	
		// if start and end index are same then we simply increment index 
		
		if (start == end) {
			arr[(end + 1) % this.circularQueue.length][0] = arr[end][0];
			arr[(end + 1) % this.circularQueue.length][0] = arr[end][0];
		}
		else if(start < rear)
		{
			// if rear is on right end of array then we update it to 0th index of array when shifting
			if (end == (arr.length - 1)) 
			{
				
				arr[0][0] = arr[end][0];
				arr[0][1] = arr[end][1];
				
				end = arr.length - 2;
			}
			// o/w we simply right shift the index
			while(end != (start - 1))
			{
				arr[end + 1][0] = arr[end][0];
				arr[end + 1][1] = arr[end][1];
				end--;
			}
		}
		else if (end < start)
		{	
			// shifting right the rear 
			while(end != -1)
			{
				arr[end + 1][0] = arr[end][0];
				arr[end + 1][1] = arr[end][1];
				end--;
			}
			// rear == 0 we simply set rear to right end 
			arr[0][0] = arr[arr.length -1][0];
			arr[0][1] = arr[arr.length -1][1];
			
			end = arr.length - 2;
			// shift remaining elements
			while( end != (start-1))
			{
				arr[end + 1][0] = arr[end][0];
				arr[end + 1][1] = arr[end][1];
				end--;
			}
		}
	}
	
	/**
	 *function to print the shifted elements 
	 */
	public void show()
	{
		for (int currentIndex = 0; currentIndex < circularQueue.length; currentIndex++) {
			System.out.print( circularQueue[currentIndex][0] + " ");
		}
		System.out.println(" currentSize: " + this.currentSize);
	}
	

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(8);
		queue.insert(10, 10);
		queue.insert(7, 7);
		queue.insert(5, 5);
		queue.insert(4, 4);
		queue.insert(3, 3);
		queue.insert(1, 1);
		queue.insert(6, 6);
		queue.show();
	}

}
