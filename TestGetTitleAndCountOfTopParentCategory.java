import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


/**
 *class to test getTitleAndCountOfTopParentCategory function of JDBC class
 */
public class TestGetTitleAndCountOfTopParentCategory {

	@Test
	public void getTitleAndCountOfTopParentCategory_void_ListOfRowsObject()
	{
		
		List<TitleAndCountOfTOPLevelCategory> computedList = JDBC.getTitleAndCountOfTopParentCategory();

		String expextedCategoryTitle[] =  {"Accessories", "clothings", "footwear" } ;
		int expectedChildCount[] = {1, 2, 4};
		
		String computedCategoryTitle[] = new String[3];
		int computedCategoryCount[] = new int[3];
		
		int count = 0;
		for(TitleAndCountOfTOPLevelCategory i : computedList )
		{
			computedCategoryTitle[count] = i.getTitle();
			computedCategoryCount[count] = i.getCount();
			count++;
		}
		
		assertArrayEquals(expextedCategoryTitle, computedCategoryTitle);
		assertArrayEquals(expectedChildCount, computedCategoryCount);
   }
	
}
