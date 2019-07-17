
public interface BaseConversion {

	/*
	 * following all function get string representation of one base numbers, then
	 * perform arithmetic operations and return back the string representation to
	 * that base
	 */

	public String add(String str1, String str2);

	public String subtract(String str1, String str2);

	public String multiply(String str1, String str2);

	public String devide(String str1, String str2);

	public boolean isEqual(String str1, String str2);

	public boolean isGreater(String str1, String str2);

	public boolean isLesser(String str1, String str2);

}
