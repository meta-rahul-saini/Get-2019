import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HCFTest{
	 private int inputNumber1;
	 private int inputNumber2;
	 private int expectedResult;
	 private NumberTheory numberTheory;
	 
	 @Before
	 public void initialize() {
		 numberTheory = new NumberTheory();
	 }
	 
	 public HCFTest(int inputNumber1, int inputNumber2, Integer expectedResult) {
	      this.inputNumber1 = inputNumber1;
	      this.inputNumber2 = inputNumber2;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { 15, 35, 5 },
	         { 21, 35, 7 },
	         { 30, 24, 6 },
	         { 33, 55,  11}
	      });
	   }
	   
	   @Test
	   public void testHCF() {
		   System.out.print(inputNumber1+" and " + inputNumber2);
		   System.out.println();
	       assertEquals(expectedResult, 
	       numberTheory.hcf(inputNumber1, inputNumber2));
	   } 
}