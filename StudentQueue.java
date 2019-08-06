
public class StudentQueue{
	
	private int currentSize; 
    private Student[] studentCircularQueue;
    private int queueSize; 
    private int rear;    
    private int front;
    
    public StudentQueue(int queueSize) {
    	this.queueSize = queueSize;
    	studentCircularQueue = new Student[this.queueSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }
    
	public Student peep(){
		if(isEmpty()){
			throw new AssertionError("empty queue.");
		}
		return studentCircularQueue[front];
	}


    /**
     * Enqueue elements to rear.
     */
    public void enqueue(Student student)
    {
        if (isFull()) {
            throw new AssertionError("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % studentCircularQueue.length;
            studentCircularQueue[rear] = student;
            currentSize++;
            
            if (front == -1) {
				front = rear;
			}
        }
    }
    
    /**
     * Dequeue element from Front.
     */
    public Student dequeue() {
        Student deQueuedElement;
        if (isEmpty()) {
            throw new AssertionError("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = studentCircularQueue[front];
            studentCircularQueue[front] = null;
            front = (front + 1) % studentCircularQueue.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
    	System.out.println(" curr size: " + currentSize + " length: " + studentCircularQueue.length);
        return (currentSize == studentCircularQueue.length);
    }

    /**
     * Check if Queue is empty.
     * @return, true if queue is empty o/w false is returned
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * 
     */
    public void showQueue()
    {
    	int queueSize = this.queueSize;
    	int front = this.front-1;
    	int elementsVisited = 0;
    	while(elementsVisited != this.currentSize)
    	{
    		front = (front + 1) % queueSize;
    		System.out.println("index: " + front + "->"+ studentCircularQueue[front]);
    		elementsVisited++;
    	}
    }
	
	public static void main(String[]args){
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(3);
		queue.enqueue(5);
		
		System.out.println(queue.isEmpty());

	}

}
