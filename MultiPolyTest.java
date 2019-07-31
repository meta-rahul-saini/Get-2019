import static org.junit.Assert.*;

import org.junit.Test;


/**this class has positive tests methods of multiPoly class
 * @author Rahul
 *
 */
public class MultiPolyTest {


	/**
	 * this tests find degree function here we pass valid expression 
	 */
	@Test
	public void findDegree1()
	{
		String poly = "8x^2y^1z^1 + 4y^2z^1 + 8x^2";
		
		MultiPoly multiPoly = new MultiPoly(poly);
		
		int expectedOutput = 4;
		
		assertEquals(expectedOutput,  multiPoly.getDegree());
	}
	

	/**
	 * this tests find degree function here we pass valid expression 
	 */
	@Test
	public void findDegree2()
	{
		String poly = "x^2y^1z^1 + 4y^2z^1 + 8x^5";
		
		MultiPoly multiPoly = new MultiPoly(poly);
		
		int expectedOutput = 5;
		
		assertEquals(expectedOutput,  multiPoly.getDegree());
	}
}
