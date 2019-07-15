import java.util.ArrayList;
import java.util.Scanner;

public class MainControllerClass {

	/*
	 * these are the utility function that we used to show message and get the input
	 * from the user
	 */

	// display message to user

	public static void displayOptions() {
		System.out.println("1. Add hexadecimal numbers");

		System.out.println("2. Subtract hexadecimal numbers");

		System.out.println("3. Multiply hexadecimal numbers");

		System.out.println("4. Devide hexadecimal numbers");

		System.out.println("5. Check, first hexadecimal number is equal to second");

		System.out.println("6. check, first hexadecimal number is greater than second");

		System.out.println("7. check, first hexadecimal number is less than second");

		System.out.println("8. Exit");

	}

	// get first number

	public static String getInputNumber() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String hexNum1 = sc.next().toUpperCase();

		String hexDigits = "0123456789ABCDEF";

		for (int index = 0; index < hexNum1.length(); index++) {
			if (!hexDigits.contains("" + hexNum1.charAt(index))) {
				throw new Exception(" Please Enter proper hex number");
			}

		}
		
		return hexNum1;
		
	}

	

	public static void main(String[] args) {

		// declare variables for holding the user hexNumber input

		String hexNum1 = "";

		String hexNum2 = "";

		// create instance for hexCalc class to calculate the hex Arithmetic
		HexCalc hexCalc = new HexCalc();
		
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		
		// variable to hold the user choice
		String choice = "";

		
		while (flag != false) {
			displayOptions();

			System.out.println("\n\nEnter your choice: ");

			ArrayList<String> choicelist = new ArrayList<>();

			choicelist.add("1");
			choicelist.add("2");
			choicelist.add("3");
			choicelist.add("4");
			choicelist.add("5");
			choicelist.add("6");
			choicelist.add("7");
			choicelist.add("8");

			choice = sc.next();

			// check weather the user enters valid choice

			if (!choicelist.contains(choice)) {
				System.out.println("Please Enter valid choice");
			} else {

				switch (Integer.valueOf(choice)) {
				case 1: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					// calculating addition of hex numbers

					String add = hexCalc.add(hexNum1, hexNum2);
					System.out.println("Addition is: " + add);

				}
					break;
				case 2: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					// calculating subtraction of hex numbers

					String add = hexCalc.subtract(hexNum1, hexNum2);
					System.out.println("Subtraction is: " + add);

				}
					break;
				case 3: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					// calculating multiplication of hex numbers

					String add = hexCalc.multiply(hexNum1, hexNum2);
					System.out.println("Multilication is: " + add);

				}
					break;
				case 4: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					// calculating devision of hex numbers

					String add = hexCalc.devide(hexNum1, hexNum2);
					System.out.println("Devision is: " + add);

				}
					break;
				case 5: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					// calculating comparison of hex numbers

					boolean isEqual = hexCalc.isEqual(hexNum1, hexNum2);
					System.out.println("is equal? " + isEqual);

				}
					break;
				case 6: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}
					// calculating comparison of hex numbers

					boolean isGreater = hexCalc.isGreater(hexNum1, hexNum2);
					System.out.println("is greater? " + isGreater);

				}
					break;
				case 7: {

					// getting input from user

					try {
						System.out.println("Enter first Hex Number");
						hexNum1 = getInputNumber();
						System.out.println("Enter second Hex Number");
						hexNum2 = getInputNumber();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					// calculating comparison of hex numbers

					boolean isLesser = hexCalc.isLesser(hexNum1, hexNum2);
					System.out.println("is lesser? " + isLesser);

				}
					break;
				case 8: {
					System.out.println("Exit:");
					flag = false;
				}

				}
			}

		}

	}

}
