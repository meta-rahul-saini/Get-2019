import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

/**this class has test cases for functions of Poly class
 * @author rahul
 *
 */
public class PolyNegativeTest {
	
	/**
	 * this function tests add function of poly class
	 */
	@Test(expected = AssertionError.class)
	public void insertTest()
	{
		Poly poly1 = new Poly();
		// we pass equation 3x^2 + 10 
		poly1.insert(3, -2);
		poly1.insert(10,0);		
	}
	
}
