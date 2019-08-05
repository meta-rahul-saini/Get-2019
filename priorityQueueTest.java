import org.junit.Test;
import static org.junit.Assert.*;
/**
 * this class has test case function for testing the methods of 
 */
public class priorityQueueTest {

	@Test
	public void insert_WhenPriorityIsGreaterThanFront_CorrectOutput()
	{
		PriorityQueue queue = new PriorityQueue(8);
		queue.insert(10, 10);
		queue.insert(7, 7);
		queue.insert(5, 5);
		queue.insert(4, 4);
		queue.insert(3, 3);
		queue.insert(1, 1);
		queue.insert(6, 80);
		
		int expectedOutput[] = {6, 10, 7, 5, 4, 3, 1, 0};
		
		int computedOutput[] = new int[8];
		
		for (int index = 0; index < computedOutput.length; index++) {
			
			computedOutput[index] = queue.circularQueue[index][0];
		}
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void insert_WhenPriorityIsLesserThanRear_CorrectOutput()
	{
		PriorityQueue queue = new PriorityQueue(5);
		queue.insert(10, 10);
		queue.insert(7, 7);
		queue.insert(5, 5);
		queue.insert(4, 4);
		queue.insert(3, 3);
		
		int expectedOutput[] = {10, 7, 5, 4, 3};
		
		queue.show();
		int computedOutput[] = new int[5];
		
		for (int index = 0; index < computedOutput.length; index++) {
			
			computedOutput[index] = queue.circularQueue[index][0];
		}
		
		queue.show();
		assertArrayEquals(expectedOutput, computedOutput);
	}
	@Test
	public void insert_WhenPriorityIsOfMiddleValue_CorrectOutput()
	{
		PriorityQueue queue = new PriorityQueue(6);
		queue.insert(10, 10);
		queue.insert(7, 7);
		queue.insert(5, 5);
		queue.insert(4, 4);
		queue.insert(3, 3);
		queue.insert(83, 6);
		
		int expectedOutput[] = {10, 7, 83, 5, 4, 3};
		
		int computedOutput[] = new int[6];
		
		for (int index = 0; index < computedOutput.length; index++) {
			
			computedOutput[index] = queue.circularQueue[index][0];
		}
		
		assertArrayEquals(expectedOutput, computedOutput);
	}

}