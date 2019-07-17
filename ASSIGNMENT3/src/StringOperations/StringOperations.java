package StringOperations;

public class StringOperations {

	/**
	 * compare strings
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int isEqual(String str1, String str2) {
		// check for the equal length
		if (str1.length() != str2.length()) {
			return 0;
		} else {
			// if length is equal then check weather they are same by iterating
			for (int index = 0; index < str1.length(); index++) {
				if (str1.charAt(index) != str2.charAt(index)) {
					return 0;
				}
			}
			// if strings are equal then return 1
			return 1;
		}
	}

	/**
	 * reverse the passed string
	 * 
	 * @param str
	 * @return
	 */
	public String reverse(String str) {
		String revString = "";
		for (int index = str.length() - 1; index >= 0; index--) {
			revString = revString + str.charAt(index);

		}
		return revString;
	}

	/**
	 * swap the case of string
	 * 
	 * @param str
	 * @return
	 */
	public String swapCase(String str) {
		int asciiValueOfChar = 0;
		int convertedCaseAsciiValue = 0;
		String caseConvertedString = "";
		for (int index = 0; index < str.length(); index++) {
			asciiValueOfChar = str.charAt(index);

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

}
