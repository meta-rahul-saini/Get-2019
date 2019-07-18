package StringOperations;

public class StringOperations {

	/**
	 * compare strings to check weather they are equal or not
	 * @param string1 string to compare
	 * @param string2 string to compare with
	 * @return returns 1 if strings are equal o/w return 0
	 */
	public int isEqual(String string1, String string2) {
		
		// check for the equal length
		if (string1.length() != string2.length()) {
			return 0;
		} else {
			// if length is equal then check weather they are same by iterating
			for (int index = 0; index < string1.length(); index++) {
				if (string1.charAt(index) != string2.charAt(index)) {
					return 0;
				}         
			}
			// if strings are equal then return 1
			return 1;
		}
	}

	/**
	 * reverse the passed string
	 * @param string input string
	 * @return string reversed string
	 */
	public String reverse(String string) {
		String revString = "";
		for (int index = string.length() - 1; index >= 0; index--) {
			revString = revString + string.charAt(index);

		}
		return revString;
	}

	/**
	 * swap the case of string i.e. Capital letter would be returned as small vice-versa
	 * @param string input string
	 * @return string swap cased String
	 */
	public String swapCase(String string) {
		int asciiValueOfChar = 0;
		int convertedCaseAsciiValue = 0;
		String caseConvertedString = "";
		for (int index = 0; index < string.length(); index++) {
			asciiValueOfChar = string.charAt(index);

			if (asciiValueOfChar >= 65 & asciiValueOfChar <= 90) {
				convertedCaseAsciiValue = asciiValueOfChar - 65 + 97;

			} else if (asciiValueOfChar >= 97 & asciiValueOfChar <= 122) {
				convertedCaseAsciiValue = asciiValueOfChar - 97 + 65;
			} else {
				convertedCaseAsciiValue = asciiValueOfChar;
			}

			caseConvertedString += (char) (convertedCaseAsciiValue);

		}

		return caseConvertedString;
	}

	
	/**
	 * find the largest word of string
	 * @param string
	 * @return String, returns largest word in the string, requires that if two maxWords are of same length then return last one
	 */
	public String findLargestWord(String string)
	{
		String words[] = string.split(" ");
		String maxWord = "";
		for(String currentWord: words)
		{
			if(maxWord.length() <= currentWord.length())
			{
				maxWord = currentWord;
			}
			
		}
		return maxWord;
	}
	
	
}
