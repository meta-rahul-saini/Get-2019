
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinearSearchTest {
	 private int arrayOfIntegers [];
	 private int searchElement;
	 private int expectedResult;
	 private Search search;
	 
	 @Before
	 public void initialize() {
		 search = new Search();
	 }
	 
	 public LinearSearchTest(int arrayOfIntegers[], int searchElement, Integer expectedResult) {
	      this.arrayOfIntegers = arrayOfIntegers;
	      this.searchElement = searchElement;
	      this.expectedResult = expectedResult;
	      
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { new int[]{1, 2, 3, 4, 5}, 5, 4 },
	         { new int[]{21, 35, 7 },9, -1},
	         { new int[]{30, 24, 6 },24, 1},
	         { new int[]{33, 55,  11}, 11, 2}
	      });
	   }
	   
	   @Test
	   public void testHCF() {
		   assertEquals(expectedResult, 
				   search.linearSearch(arrayOfIntegers, searchElement));
	   } 
}
