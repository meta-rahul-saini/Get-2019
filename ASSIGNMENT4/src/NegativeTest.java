import org.junit.Test;
import org.junit.Before;

public class NegativeTest {
	 private ArrOperations arrOperations;	 
	 @Before
	 public void initialize() {
		 arrOperations = new ArrOperations();
	 }
	 
	 @Test(expected = AssertionError.class)
	 public void maxMirrorAE() {
		 arrOperations.findMaxMirror(new int[]{});
	 }
	   
	 @Test(expected = AssertionError.class)
	 	public void countClumpsAE() { 
		arrOperations.countClumps(new int[]{});
	 }
	   
	 @Test(expected = AssertionError.class)
	 	public void fixXYAE() { 
		arrOperations.fixXY(new int[]{}, 0 , 0);
	 }
	   
	 @Test(expected = AssertionError.class)
	 	public void splitArrayAE() { 
		 arrOperations.findSplitArrayIndex(new int[]{});
	 }
}