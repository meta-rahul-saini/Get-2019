public class Stack {

	private Node top; 

    public Stack() 
    { 
        this.top = null; 
    } 
   
    /** function to add/push element on stack
     * @param x
     */
    public void push(int x) 
    { 
        Node node = new Node(x); 
        node.data = x;
        
        node.next = top; 
        
        top = node; 
    } 
    
   
    /** function to pop element from stack
     * @param x
     */
    public int pop()
    { 
        if (this.top == null) { 
            throw new AssertionError("stack is empty"); 
        } 
        int data = this.top.getData();
        this.top = this.top.next;
        return data;
    } 
    
    /** function to check weather the stack is empty or not
     * @return, true if stack is empty o/w false
     */
    public boolean isEmpty() 
    { 
        return top == null; 
    } 
    
    /** function to return top element
     * @return, -1 if stack is empty o/w return false;
     */
    public int peek() 
    { 
        if (!isEmpty()) 
        { 
            return top.data; 
        } 
        else 
        { 
            return -1; 
        } 
    } 
 
	/**
	 *	function to display stack elements 
	 */
	public void display() 
    { 
        if (top == null) 
        { 
        	System.out.println("stack is empty");
        } 
        else 
        { 
            Node currentNode = top; 
            while (currentNode != null) 
            { 
                System.out.printf(" : " + currentNode.data); 
                currentNode = currentNode.next; 
            } 
        } 
    } 
} 
	 


