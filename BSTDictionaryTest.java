import static org.junit.Assert.*;

import org.junit.Test;

/**
 *this class has test cases for methods in BSTDictionary
 */
public class BSTDictionaryTest {

	@Test
	public void search_TY_ThankYou()
	{
		BSTDictionary dict = new BSTDictionary();
		dict.readJsonFile();
		assertEquals("Thank You", dict.search("TY"));
	}
	
	@Test(expected = AssertionError.class)
	public void search_WordNotPresentInDict_ThrowAssertionError()
	{
		BSTDictionary dict = new BSTDictionary();
		dict.readJsonFile();
		dict.search("CM");
	}
	
	@Test
	public void findInOrderSuccessor_RootNode_GN()
	{
		BSTDictionary dict = new BSTDictionary();
		dict.readJsonFile();
		String expectedOutput = "GN";
		String computedOutput =dict.findInorderSuccessor(dict.root);
		
		assertEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void getSortedValues_rootNode_SortedNodeList()
	{
		BSTDictionary dict = new BSTDictionary();
		dict.readJsonFile();

		BSTLinkedList sortedList = dict.getSortedValues(dict.root);
		
		String expectedOutpu[] = {"CO", "GM", "GN", "OK", "RIP", "TY", "Z"};
		String computedArray[] = new String[7];
		
		BSTLinkedListNode iterator = sortedList.getFront();
		
		int currentIndex = 0;
		while(iterator !=  null)
		{
			computedArray[currentIndex] = iterator.key;
			iterator = iterator.next;
			currentIndex++;
		}
		assertArrayEquals(expectedOutpu, computedArray);
	}
	
	@Test
	public void getSortedBwKeys_rootNode_SortedNodeListBtKeysGiven()
	{
		BSTDictionary dict = new BSTDictionary();
		dict.readJsonFile();

		BSTLinkedList sortedListByKey = dict.getSortedValues(dict.root, "CO", "RIP");
		
		String expectedOutpu[] = {"CO", "GM", "GN", "OK", "RIP"};
		
		String computedArray[] = new String[5];
		
		BSTLinkedListNode iterator = sortedListByKey.getFront();
		
		int currentIndex = 0;
		while(iterator !=  null)
		{
			computedArray[currentIndex] = iterator.key;
			iterator = iterator.next;
			currentIndex++;
		}
		assertArrayEquals(expectedOutpu, computedArray);
	}
}
