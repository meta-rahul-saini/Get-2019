import static org.junit.Assert.*;

import org.junit.Test;


/**this class has test cases for methods of ViratAndBowler
 * @author Rahul
 *
 */
public class ViratAndBowlerTest {

	@Test
	public void getBowlerOrder_WhenViratPlayLesserThanBowlers_CorrectOrder()
	{

		int[][] bowlerArray = new int[][]{
				{0,5},
				{1,15},
				{2,10},
				{3,8},
				{4,11},
				{5,16},
				{6,2},
				{7,19},
				{8,7},
				{9,6},
				{10,2},
				{11,4},
				{12,7}
		};
		
		ViratAndBowler vb = new ViratAndBowler(13,15,bowlerArray);
		int[] computedOutput = vb.getBowlerOrder();
		
		int [] expectedOutput = {7, 7, 7, 7, 5, 5, 7, 1, 1, 5, 7, 7, 1, 5, 5};
		
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
	@Test(expected = AssertionError.class)
	public void getBowlerOrder_WhenViratPlayMoreBowlsThanBowlers_CorrectOrder()
	{

		int[][] bowlerArray = new int[][]{
				{0,5},
				{1,15},
				{2,10},
				{3,8},
		};
		
		new ViratAndBowler(4,100,bowlerArray);
		
	}
	
}
