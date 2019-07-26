import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

/**this class has test cases for functions of Poly class
 * @author rahul
 *
 */
public class PolyTest {

	/**
	 * this function tests evaluate() function of Poly class for corner values of x like 0.0, 0.2, 3 etc.
	 */
	@Test
	public void evaluateTest() {
		
		Poly poly = new Poly();
		
		// we pass equation 3x^2 + 5x + 10 
		poly.insert(3, 2);
		poly.insert(2, 1);
		
		// here we are inserting multiple coefficient value with same power
		poly.insert(3, 1);
		poly.insert(10,0);
				
		// we test it on x = 3
		float delta = 0;
		
		assertEquals(52.0, poly.evaluate(3), delta);

		// if x == 0.2F 
		assertEquals(11.12, poly.evaluate(0.2F), delta);
		
		// if x == 0.0F
		assertEquals(10, poly.evaluate(0.0F), delta);	
	}
	
	/**
	 * this function tests getDegree() function of Poly class, for corner cases like degeree 0, 2 etc.
	 */
	@Test
	public void getDegreeTest() {
		
		Poly poly1 = new Poly();
		// we pass equation 3x^2 + 5x + 10 
		poly1.insert(3, 2);
		poly1.insert(5, 1);
		poly1.insert(10,0);
		
		assertEquals(2, poly1.getDegree());
		
		Poly poly2 = new Poly();
		// we pass equation 3x^2 + 5x + 10 
		poly2.insert(3, 0);
		
		assertEquals(0, poly2.getDegree());
	}
	
	
	/**
	 * this function tests add function of poly class
	 */
	@Test
	public void addTest()
	{
		Poly poly1 = new Poly();
		// we pass equation 3x^2 + 5x + 10 
		poly1.insert(3, 2);
		poly1.insert(5, 1);
		poly1.insert(10,0);
		
		Poly poly2 = new Poly();
		
		// we pass equation 12x^3 + 2x^2 + 15 
		poly2.insert(12, 3);
		poly2.insert(2, 2);
		poly2.insert(15,0);

		// actual output of above polynomial is : 12x^3 + 5x^2 + 5x + 25
		Poly actualOutput = new Poly();
		actualOutput.insert(12, 3);
		actualOutput.insert(5, 2);
		actualOutput.insert(5, 1);
		actualOutput.insert(25, 0);
		
		Poly computedOutput = poly1.add(poly2);
		
		assertEquals(true, actualOutput.isEquals(computedOutput));
		
	}
	
	
	/**
	 * this function tests add function of poly class
	 */
	@Test
	public void multiplyTest()
	{
		Poly poly1 = new Poly();
		// we pass equation 3x^2 + 10 
		poly1.insert(3, 2);
		poly1.insert(10,0);
		
		Poly poly2 = new Poly();
		
		// we pass equation 2x^3 + 2x 
		poly2.insert(2, 3);
		poly2.insert(2, 1);

		// actual output of above polynomial is : 6x^5 + 26x^3 + 20x
		Poly actualOutput = new Poly();
		actualOutput.insert(6, 5);
		actualOutput.insert(26, 3);
		actualOutput.insert(20, 1);
		
		Poly computedOutput = poly1.multiply(poly2);
	
		assertEquals(true, actualOutput.isEquals(computedOutput));
		
	}
	
}
