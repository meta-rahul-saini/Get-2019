import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueNegativeTest {


	@Test(expected = AssertionError.class)
	public void enqueueTestWhenQueueIsFull() {
		CircularQueue circularQueue = new CircularQueue(3);
		circularQueue.enqueue(2);
		circularQueue.enqueue(3);
		circularQueue.enqueue(4);
		circularQueue.enqueue(5);
	}


	@Test(expected = AssertionError.class)
	public void dequeueTestWhenQueueIsEmpty() {
		CircularQueue circularQueue = new CircularQueue(3);
		circularQueue.dequeue();
	}

}
