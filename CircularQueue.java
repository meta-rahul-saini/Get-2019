
public class CircularQueue {
	
	private int currentSize; 
    private int[] circularQueue;
    private int queueSize; 
    private int rear;    
    private int front;
    
    public CircularQueue(int queueSize) {
    	this.queueSize = queueSize;
        circularQueue = new int[this.queueSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }
    
    
    /**
     * Enqueue elements to rear. 
     * it throws AssertionError if queue is full 
     */
    public void enqueue(int item)
    {
        if (isFull()) {
            throw new AssertionError("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % circularQueue.length;
            circularQueue[rear] = item;
            currentSize++;
            
            if (front == -1) {
				front = rear;
			}
        }
    }
    
    /**Dequeue element from Front.
     * @return, returns dequeued element, throws assertionError if queue is empty.
     */
    public int dequeue() {
        int deQueuedElement;
        if (isEmpty()) {
            throw new AssertionError("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueue[front];
            circularQueue[front] = '\0';
            front = (front + 1) % circularQueue.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    
    /** Check if queue is full.
     * @return true if queue is full o/w false is returned.
     */
    public boolean isFull() {
    	System.out.println(" curr size: " + currentSize + " length: " + circularQueue.length);
        return (currentSize == circularQueue.length);
    }

    /**
     * Check if Queue is empty.
     * @return, true if queue is empty o/w false is returned
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * function to show queue elements
     */
    public void showQueue()
    {
    	int queueSize = this.queueSize;
    	int front = this.front-1;
    	int elementsVisited = 0;
    	while(elementsVisited != this.currentSize)
    	{
    		front = (front + 1) % queueSize;
    		System.out.println("index: " + front + "->"+ circularQueue[front]);
    		elementsVisited++;
    	}
    }

    public static void main(String[] args) {

        CircularQueue circularQueue = new CircularQueue(8);

        circularQueue.enqueue(15);
        
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.dequeue();
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);
        circularQueue.enqueue(26);
        circularQueue.enqueue(25);
        circularQueue.dequeue();
        
        circularQueue.enqueue(250);

        circularQueue.showQueue();
    }





}
