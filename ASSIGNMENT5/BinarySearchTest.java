

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinarySearchTest {
	 private int arrayOfIntegers [];
	 private int searchElement;
	 private int expectedResult;
	 private Search search;
	 
	 @Before
	 public void initialize() {
		 search = new Search();
	 }
	 
	 public BinarySearchTest(int arrayOfIntegers[], int searchElement, Integer expectedResult) {
	      this.arrayOfIntegers = arrayOfIntegers;
	      this.searchElement = searchElement;
	      this.expectedResult = expectedResult;
	      
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { new int[]{1, 2, 3, 4, 5}, 5, 4 },
	         { new int[]{7, 8, 10 },9, -1},
	         { new int[]{30, 33, 56, 100},56, 2},
	         { new int[]{11, 22, 1000}, 11, 0}
	      });
	   }
	   
	   @Test
	   public void testHCF() {
		   assertEquals(expectedResult, 
				   search.binarySearch(arrayOfIntegers, searchElement));
	   } 
}
