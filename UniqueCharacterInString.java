import java.util.HashMap;
import java.util.Map;

public class UniqueCharacterInString {

	Map<String, Integer> uniqueCharInStringMap = new HashMap<String, Integer>();

	public int countUniqueCharIntStringMap(String string) 
	{
		
		// converting to all lower case 
		string = string.toLowerCase();
		
		Integer noOfUniqueChar = 0;
		Character currentChar = 0;

		// if we already have the #uniqueChar for that string we simply return the value for that string
		if (uniqueCharInStringMap.containsKey(string)) 
		{
			return uniqueCharInStringMap.get(string);
		} 
		// if we don't have then we have to count
		else 
		{
			Map<Character, Integer> uniqueCharMap = new HashMap<Character, Integer>();
			
			for (int currentCharIndex = 0; currentCharIndex < string.length(); currentCharIndex++) 
			{
				currentChar = string.charAt(currentCharIndex);
				uniqueCharMap.put(currentChar,
						uniqueCharMap.getOrDefault(currentChar, 0) + 1);
			}

			for (Character currentCharKey : uniqueCharMap.keySet()) 
			{
				if (uniqueCharMap.get(currentCharKey) == 1) 
				{
					noOfUniqueChar++;
				}
			}

			// storing the #uniqueChar for that string in map for the future purpose
			
			uniqueCharInStringMap.put(string, noOfUniqueChar);

			return noOfUniqueChar;
		}
	}

	public static void main(String... args) {

		UniqueCharacterInString uniqueCharacterInString = new UniqueCharacterInString ();
		System.out.println("Rahul: " + uniqueCharacterInString.countUniqueCharIntStringMap("raaahul Sainiii"));
	}
}
