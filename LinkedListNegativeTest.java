import org.junit.Test;


/**negative test case class for testing methods of linkedlist
 * @author Rahul
 *
 */
public class LinkedListNegativeTest {

	/**
	 * when user try to rotate an empty list
	 */
	@Test(expected = AssertionError.class)
	public void testRotateSubList1()
	{
		LinkedList linkedList = new LinkedList();
		
		// if user perform rotation on empty list
		
		linkedList.rotateSubList(1, 4, 3);
	}
	
	/**
	 * when user passes left index which is more than size of list
	 */
	@Test(expected = AssertionError.class)
	public void testRotateSubList2()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		
		linkedList.showList();
		
		// if user passes left position more than the size of list 
		linkedList.rotateSubList(5, 6, 2);
	}
	
	/**
	 * user try to check loop in empty list
	 */
	@Test(expected = AssertionError.class)
	public void testIfLoopExists()
	{
		LinkedList linkedList = new LinkedList();
		
		// if user passes empty list
		linkedList.ifLoopExists();
	}
}
