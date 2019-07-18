
public interface BaseConversion {

	/**
	 * returns addition of hexadecimal numbers
	 * @param string1, string to add 
	 * @param string2, string to add with
	 * @return string , returns addition of hexadecimal numbers in string
	 */
	public String add(String string1, String string2);

	/**
	 * returns subtraction of hexadecimal numbers
	 * @param string1, string to subtract 
	 * @param string2, string to subtract with
	 * @return string , returns subtraction of hexadecimal numbers in string
	 */
	public String subtract(String string1, String string2);

	/**
	 * returns multiplication of hexadecimal numbers
	 * @param string1, string to multiply 
	 * @param string2, string to multiply with
	 * @return string , returns multiplication of hexadecimal numbers in string
	 */
	public String multiply(String string1, String string2);

	
	/**returns subtraction of hexadecimal numbers
	 * @param string1, dividend
	 * @param string2, divisor, if it is zero then we simply return null string
	 * @return, returns null string if divisor is zero else division is returned 
	 */
	public String devide(String string1, String string2);

	
	/**check weather the string1 is equal to string2
	 * @param string1, string to compare
	 * @param string2, string to compare with
	 * @return, returns true if strings are equal o/w false
	 */
	public boolean isEqual(String string1, String string2);

	/**check weather the string1 is greater than string2
	 * @param string1, string to compare
	 * @param string2, string to compare with
	 * @return, returns true if first string is greater, o/w false
	 */
	public boolean isGreater(String string1, String string2);

	/**check weather the string1 is lesser than string2
	 * @param string1, string to compare
	 * @param string2, string to compare with
	 * @return, returns true if first string is lesser, o/w false
	 */
	public boolean isLesser(String string1, String string2);

}
