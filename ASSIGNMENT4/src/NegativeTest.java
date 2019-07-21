import org.junit.Test;
import org.junit.Before;

public class NegativeTest {
	 private ArrOperations arrOperations;	 
	 @Before
	 public void initialize() {
		 arrOperations = new ArrOperations();
	 }
	 
	 
	 
	 /**
	 * if array is empty:  throw assertion error.
	 * else :  returns max mirror in array
	 * 
	 */
	@Test(expected = AssertionError.class)
	 public void maxMirrorAE() {
		 arrOperations.findMaxMirror(new int[]{});
	 }
	   

	 /**
	 * if array is empty:  throw assertion error.
	 * else :   returns no of clumps in array
	 */
	 @Test(expected = AssertionError.class)
	 	public void countClumpsAE() { 
		arrOperations.countClumps(new int[]{});
	 }
	   
	 /**
	 * if array is empty:      throw assertion error.
	 * if unequal no. of x and Y:   throw assertion error.
	 * if two adjacent X values are there: 	throw assertion error
	 * if X occurs at last index of array: 	throw assertion error
	 * else    :   returns no of clumps in array
	 */
	 @Test(expected = AssertionError.class)
	 	public void fixXYAE() { 
		arrOperations.fixXY(new int[]{}, 0 , 0);
	 }
	   

	 /**
	 * if array is empty:   throw assertion error.
	 * else :   returns split index in array
	 */
	 @Test(expected = AssertionError.class)
	 	public void splitArrayAE() { 
		 arrOperations.findSplitArrayIndex(new int[]{});
	 }
}
