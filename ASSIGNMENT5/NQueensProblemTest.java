import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NQueensProblemTest {
	 private int dimension;
	 private int startRow;
	 private boolean expectedResult;
	 private NQueensProblem nQueensProblem;
	 
	 @Before
	 public void initialize() {
		 nQueensProblem = new NQueensProblem();
	 }
	 
	 public NQueensProblemTest(int dimension, int startRow, boolean expectedResult) {
	      this.dimension = dimension;
	      this.startRow = startRow;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
		 {0, 0, true},
	    	 { 2, 0, false},
	    	 { 3, 0, false },
	         { 4, 2, true },
	         { 5, 2, true },
	         { 6, 5, true },
	         { 7, 3, true },
	         { 8, 3, true },
	         { 9, 8, true },
	      });
	   }
	   
	   @Test
	   public void testMaxMirror() {
		  System.out.println(" " + dimension);
		  int[][] board = nQueensProblem.createBoard(dimension);
	      assertEquals(expectedResult, 
	    		  nQueensProblem.SolveNQueen(board,startRow,dimension));
	   } 
}
