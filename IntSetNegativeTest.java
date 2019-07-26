import static org.junit.Assert.*;

import org.junit.Assert;

import org.junit.Test;

/**this class has negative test cases for testing IntSet member functions
 * @author rahul
 *
 */
public class IntSetNegativeTest {
	
	/**
	 * this function test range of intSet class, i.e. tests weather it accepts 
	 * values outside the range or not (1, 1000)
	 */
	@Test(expected = AssertionError.class)
	public void rangeTest() {
		Integer[] input1 = { 1, 2, -3, 4, 5, -5, 5, 5 };
		IntSet set = new IntSet(input1);
	}
}