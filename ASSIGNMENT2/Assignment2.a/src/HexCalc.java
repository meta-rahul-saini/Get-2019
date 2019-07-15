
/* HexCalc Class implements BaseConversion interface to ensure the complete implementation of BaseConversion Interface requirement*/


public class HexCalc implements BaseConversion {

	
	// we use this function to convert hex to decimal
	
	public static String hexToDecimal(String hex) {

		// we first change all user entered hex digits to uppercase so that there should not generate any inconsistency due to lower case characters.
		
		hex = hex.toUpperCase();
		int decimal = 0;
		String hexdigits = "0123456789ABCDEF";
		int len = hex.length();
		
		// iterate over hex string and convert to decimal 
		
		for (int i = 0; i < len; i++) {

			char currentChar = hex.charAt(i);
			
			// getting the decimal digits for each user_entered hex digits
			
			int decimalOfCurrentChar = hexdigits.indexOf(currentChar);
			decimal += decimalOfCurrentChar * Math.pow(16, len - i - 1);
		}
		
		// converting decimal integer back to string
		String decimalInString = Integer.toString(decimal);
		return decimalInString;
	}

	public static String decimalToHex(String dec) {
 
		// integer representation of string data
		
		int decimal = Integer.valueOf(dec);

		String hexdigits = "0123456789ABCDEF";

		int reminder = 0;
		String hex = "";

		// convert decimal to hexadecimal data
		
		while (decimal > 0) {
			reminder = decimal % 16;
			hex = hexdigits.charAt(reminder) + hex;
			decimal = decimal / 16;
		}

		return hex;
	}

	public String add(String hex1, String hex2) {

		// getting decimal integer value corresponding to hexadecimal numbers
		
		int decimal1 = Integer.valueOf(hexToDecimal(hex1));
		int decimal2 = Integer.valueOf(hexToDecimal(hex2));

		// performing addition and convert back to string 
		
		String result = Integer.toString(decimal1 + decimal2);

		// converting back decimal to hexadecimal
		
		String resultInHex = decimalToHex(result);

		return resultInHex;
	}

	public String subtract(String hex1, String hex2) {
		
		// getting decimal integer value corresponding to hexadecimal numbers
		
		int decimal1 = Integer.valueOf(hexToDecimal(hex1));
		int decimal2 = Integer.valueOf(hexToDecimal(hex2));

		// performing subtraction and convert back to string 
		
		String result = Integer.toString(decimal1 - decimal2);

		String resultInHex = decimalToHex(result);

		return resultInHex;
	}

	public String multiply(String hex1, String hex2) {

		// getting decimal integer value corresponding to hexadecimal numbers
		
		int decimal1 = Integer.valueOf(hexToDecimal(hex1));
		int decimal2 = Integer.valueOf(hexToDecimal(hex2));

		// performing multiplication and convert back to string 
		
		String result = Integer.toString(decimal1 * decimal2);

		String resultInHex = decimalToHex(result);

		return resultInHex;
	}

	public String devide(String hex1, String hex2) {

		// getting decimal integer value corresponding to hexadecimal numbers
		
		int decimal1 = Integer.valueOf(hexToDecimal(hex1));
		int decimal2 = Integer.valueOf(hexToDecimal(hex2));

		// performing devision and convert back to string 
		
		String result = Integer.toString(decimal1 / decimal2);

		String resultInHex = decimalToHex(result);

		return resultInHex;
	}

	// return true if both hex strings are equal
	
	public boolean isEqual(String hex1, String hex2) {

		if (hex1.length() == hex2.length()) {
			if (hex1.compareTo(hex2) == 0)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	// return true if first hex strings is greater
	
	public boolean isGreater(String hex1, String hex2) {

		if (hex1.length() > hex2.length())
			return true;
		else {
			if (hex1.compareTo(hex2) > 0)
				return true;
			else
				return false;
		}
	}

	// return true if first hex string is lesser
	public boolean isLesser(String hex1, String hex2) {

		if (hex1.length() < hex2.length())
			return true;
		else {
			if (hex1.compareTo(hex2) < 0)
				return true;
			else
				return false;
		}

	}



}
