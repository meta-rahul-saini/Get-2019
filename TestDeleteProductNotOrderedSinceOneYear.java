import static org.junit.Assert.*;

import org.junit.Test;

/**
 *class used to test the operations of deleteProductsWhichAreNotBoughtSinceLastOneYear function in JDBC class
 */
public class TestDeleteProductNotOrderedSinceOneYear {

	@Test
	public void deleteProductsWhichAreNotBoughtSinceLastOneYear_void_arrayOfStatus()
	{
		
		int deletedRows = JDBC.deleteProductsWhichAreNotBoughtSinceLastOneYear();
		int expectedNoOfRowsDeletetion  = 5;
		assertEquals(expectedNoOfRowsDeletetion, deletedRows);
   }
}
