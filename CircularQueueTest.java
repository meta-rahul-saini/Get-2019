import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void isFullTestWhenQueueIsFul() 
	{
		CircularQueue circularQueue = new CircularQueue(3);

		circularQueue.enqueue(15);

		circularQueue.enqueue(16);
		
		circularQueue.enqueue(16);
		
		assertEquals(true, circularQueue.isFull());
		
	}
	
	@Test
	public void isFullTestWhenQueueIsNotFull() 
	{
		CircularQueue circularQueue = new CircularQueue(3);

		circularQueue.enqueue(15);

		circularQueue.enqueue(16);
		
		assertEquals(false, circularQueue.isFull());
	}
	
	@Test
	public void isEmptyTestWhenQueueIsEmpty() 
	{
		CircularQueue circularQueue = new CircularQueue(3);

		circularQueue.enqueue(15);

		circularQueue.enqueue(16);
		
		circularQueue.dequeue();
		circularQueue.dequeue();
		
		assertEquals(true, circularQueue.isEmpty());
	}	
	
	@Test
	public void isEmptyTestWhenQueueIsNotEmpty() 
	{
		CircularQueue circularQueue = new CircularQueue(3);

		circularQueue.enqueue(15);

		circularQueue.enqueue(16);
		
		circularQueue.dequeue();
		
		assertEquals(false, circularQueue.isEmpty());
	}
	
	@Test
	public void dequeueTestWhenQueueIsNotEmpty() 
	{
		CircularQueue circularQueue = new CircularQueue(3);

		circularQueue.enqueue(15);

		circularQueue.enqueue(16);
		
		int expectedOutput = 15;
		assertEquals(true, expectedOutput == circularQueue.dequeue());
	}
}
