import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**this class has negative tests methods of multiPoly class
 * @author Rahul
 *
 */
public class MultiPolyNegativeTest {
	/**
	 * this tests find degree function here we pass invalid expression 
	 */
	@Test(expected = AssertionError.class)
	public void findDegree1()
	{
		String poly = "8x^^2";
		
		MultiPoly multiPoly = new MultiPoly(poly);
		
	}
	

	/**
	 * this tests find degree function here we pass invalid expression 
	 */
	@Test(expected = AssertionError.class)
	public void findDegree2()
	{
		String poly = "x^2y^1*z^1 + 4y^2z^1 + 8x^5";
		
		MultiPoly multiPoly = new MultiPoly(poly);
	}
	
	@Test(expected = AssertionError.class)
	public void findDegree3()
	{
		String poly = "8x22";
		
		MultiPoly multiPoly = new MultiPoly(poly);
		
	}
}
