import static org.junit.Assert.*;

import org.junit.Assert;

import org.junit.Test;

/**this class has test cases for testing IntSet member functions
 * @author rahul
 *
 */
public class IntSetTest {
	
	/**
	 * this function test isMember() function of intSet class,
	 * which checks, weather an integer is member of current intSet or not
	 */
	@Test
	public void isMemberTest() {
		Integer[] input1 = { 1, 2, 3, 4, 5, 5, 5, 5 };
		IntSet set = new IntSet(input1);
		
		boolean flag = set.isMember(3);
		
		set.showIntSet();
		System.out.println(flag);

		assertEquals(true, set.isMember(3));
		
		assertEquals(false, set.isMember(9));
	}

	/**
	 * this function is used to test size() function
	 */
	@Test
	public void sizeTest() {
		Integer[] input = { 1, 2, 3, 4, 5, 5, 6, 5 };
		IntSet set = new IntSet(input);
		assertEquals((Integer) 6, (Integer) set.size());
	}

	/**
	 * this function tests isSubSet() method in IntSet class,
	 * which checks weather one intSet is subset of another or not
	 */
	@Test
	public void isSubsetTest() {
		Integer[] input1 = { 1, 2, 3, 4, 5, 5, 6, 5 };
		Integer[] input2 = { 2, 3, 4, 6, 4 };
		IntSet set = new IntSet(input1);
		IntSet subSet = new IntSet(input2);
		assertEquals(true, set.isSubSet(subSet));
	}

	/**
	 * this function tests union() function in IntSet class,
	 * which checks weather computed union of two intSet is equals to original union or not
	 */
	@Test
	public void unionTest() {
		Integer[] input1 = { 1, 2, 3, 4, 5};
		Integer[] input2 = { 7, 8, 9, 10 };
		Integer[] actualUnion = { 1, 2, 3, 4, 5, 7, 8, 9, 10};
		
		IntSet firstset = new IntSet(input1);
		IntSet secondset = new IntSet(input2);
		
		IntSet actualUnionSet = new IntSet(actualUnion);
		
		IntSet computedUnionSet = firstset.union(secondset);
		
		Assert.assertEquals( true, actualUnionSet.isEqual(computedUnionSet));
	}
	
	/**
	 * this function tests getComplement() function in IntSet class,
	 * which checks weather computed complement of a intSet is equals to original intSet or not
	 */
	public void getComplementTest()
	{
		Integer[] input1 = {1, 2, 3, 4, 5};
		
		IntSet intSet = new IntSet(input1);
		
		Integer[] originalComplement = new Integer[995];
		
		for(int value = 6, index=0; value <= 1000; value++, index++)
		{
			originalComplement[0] = value;
		}
		
		IntSet originalComplementIntSet = new IntSet(originalComplement);
		IntSet computedComplementOfIntSet = intSet.getComplement();
		
		Assert.assertEquals(true, originalComplementIntSet.isEqual(computedComplementOfIntSet));
		
	}
}