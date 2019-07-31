import static org.junit.Assert.*;

import org.junit.Test;


/** this test class tests the methods of linked list
 * @author Rahul
 *
 */
public class LinkedListTest {

	/**
	 * this tests positive test case of rotateSublist function when we pass unique elements
	 */
	@Test
	public void testRotateSubList1()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		linkedList.showList();

		LinkedList computedOutputList = linkedList.rotateSubList(1, 5, 2);
		
		LinkedList actualOutputList = new LinkedList();
		actualOutputList.addNode(4);
		actualOutputList.addNode(5);
		actualOutputList.addNode(1);
		actualOutputList.addNode(2);
		actualOutputList.addNode(3);
		
		
		int expectedOutputArray[] = new int[] {4, 5, 1, 2, 3};
		
		int computedOutputArray[] = new int[5];
		
		int currentIndexComputedOutputArray =0;
		
		Node iterator = computedOutputList.getFront();
		
		while(iterator != null)
		{
			System.out.println("get data: " + iterator.getData());
			computedOutputArray [currentIndexComputedOutputArray] = iterator.getData();
			currentIndexComputedOutputArray++;
			iterator = iterator.next;
		}
		assertArrayEquals(expectedOutputArray, computedOutputArray);
	}
	
	/**
	 * this tests positive test case of rotateSublist function when we pass duplicate elements
	 */
	@Test
	public void testRotateSubList2()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(5);
		linkedList.addNode(3);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		linkedList.showList();

		LinkedList computedOutputList = linkedList.rotateSubList(1, 5, 2);
		
		int expectedOutputArray[] = new int[] {4, 5, 5, 3, 3};
		
		int computedOutputArray[] = new int[5];
		
		int currentIndexComputedOutputArray =0;
		
		Node iterator = computedOutputList.getFront();
		
		while(iterator != null)
		{
			System.out.println("get data: " + iterator.getData());
			computedOutputArray [currentIndexComputedOutputArray] = iterator.getData();
			currentIndexComputedOutputArray++;
			iterator = iterator.next;
		}
		
		assertArrayEquals(expectedOutputArray, computedOutputArray);
	
	}
	
	/**
	 * this tests positive test case of rotateSublist function when we pass R position > size of list
	 */
	@Test
	public void testRotateSubList3()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		
		linkedList.showList();
		
		// if user passes R length which is more than elements in list we simply assume end of list
		LinkedList rotatedList = linkedList.rotateSubList(2, 6, 2);
		
		int expectedOutputArray[] = new int[] {2, 4, 5, 3};
		
		int computedOutputArray[] = new int[4];
		
		int currentIndexComputedOutputArray =0;
		
		Node iterator = rotatedList.getFront();
		
		while(iterator != null)
		{
			computedOutputArray [currentIndexComputedOutputArray] = iterator.getData();
			currentIndexComputedOutputArray++;
			iterator = iterator.next;
		}
		
		assertArrayEquals(expectedOutputArray, computedOutputArray);
		
	}
	
	/**
	 * this tests positive test case of ifLoopExists method when we have loop
	 */
	@Test
	public void testIfLoopExists1()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		Node front = linkedList.getFront();
		Node rear = linkedList.getRear();
		rear.next = front;
		
		assertEquals(true, linkedList.ifLoopExists());
	}
	
	
	/**
	 * this tests positive test case of ifLoopExists method when we have don't loop
	 */
	@Test
	public void testIfLoopExists2()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		
		assertEquals(false, linkedList.ifLoopExists());
	}
	
}
