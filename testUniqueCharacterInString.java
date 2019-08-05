import static org.junit.Assert.*;

import org.junit.Test;


public class testUniqueCharacterInString {

	@Test
	public void countUniqueCharIntStringMapWhenUserPassesAllDuplicate()
	{
		UniqueCharacterInString uniqueCharacterInString = new UniqueCharacterInString ();
		
		int expectedOutput = 0;
		
		assertEquals(expectedOutput, uniqueCharacterInString.countUniqueCharIntStringMap("RRAAhHuUlL"));
	}
	
	@Test
	public void countUniqueCharIntStringMapWhenUserPassesSpaceSeparatedString()
	{
		UniqueCharacterInString uniqueCharacterInString = new UniqueCharacterInString ();
		
		int expectedOutput = 3;
		
		assertEquals(expectedOutput, uniqueCharacterInString.countUniqueCharIntStringMap("A B C"));
	}
	
	@Test
	public void countUniqueCharIntStringMapWhenUserPassesAllUniqueString()
	{
		UniqueCharacterInString uniqueCharacterInString = new UniqueCharacterInString ();
		
		int expectedOutput = 3;
		
		assertEquals(expectedOutput, uniqueCharacterInString.countUniqueCharIntStringMap("ABC"));
	}
	
}
