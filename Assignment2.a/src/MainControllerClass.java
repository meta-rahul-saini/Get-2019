import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainControllerClass {

	// get first number

	public static String getInputHexNumber() {

		Scanner sc = new Scanner(System.in);

		String hexNum1 = "";
		final String pattern = "[0123456789ABCDEF]*";
		boolean isHex;
		boolean error = true;
		do {
			sc = new Scanner(System.in);

			System.out.println("Enter hex Number");
			hexNum1 = sc.next();
			isHex = Pattern.matches(pattern, hexNum1);
			if (isHex) {
				error = false;
			} else {
				System.out.println("Please Enter a valid Hex Number");
			}
		} while (error == true);
		return hexNum1;

	}
	

	public static void main(String[] args) {

		// declare variables for holding the user hexNumber input

		String hexNum1 = "";

		String hexNum2 = "";

		// create instance for hexCalc class to calculate the hex Arithmetic
		HexCalc hexCalc = new HexCalc();

		// scanner class instance
		
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		// variable to hold the user choice
		int choice = 0;

		while (flag != false) {
			
			// show options to user
			System.out.println("1. Add hexadecimal numbers");

			System.out.println("2. Subtract hexadecimal numbers");

			System.out.println("3. Multiply hexadecimal numbers");

			System.out.println("4. Devide hexadecimal numbers");

			System.out
					.println("5. Check, first hexadecimal number is equal to second");

			System.out
					.println("6. check, first hexadecimal number is greater than second");

			System.out
					.println("7. check, first hexadecimal number is less than second");

			System.out.println("8. Exit");

			// check weather the user enters valid choice
			boolean error = true;
			do {
				try {
					System.out.println("Enter your choice:\n");
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					if (choice < 1 | choice > 8) {
						System.out.println("Please Enter a valid positive integer");
						error = true;
					} else {
						error = false;
						if (choice == 8) {
							System.out.println("Exiting System");
							System.exit(0);
						}
					}
				} catch (InputMismatchException e) {
					System.out
							.println("Input Mismatch Exception occured. Please Enter a valid Positive Integer");
				}
			} while (error == true);

			// getting input from user

			hexNum1 = getInputHexNumber();
			hexNum2 = getInputHexNumber();

			switch (choice) {
			case 1: 
				// calculating addition of hex numbers
				String add = hexCalc.add(hexNum1, hexNum2);
				System.out.println("Addition is: " + add);
				break;
			
			case 2:
				// calculating subtraction of hex numbers
				String sub = hexCalc.subtract(hexNum1, hexNum2);
				System.out.println("Subtraction is: " + sub);
				break;
			
			case 3:
				// calculating multiplication of hex numbers
				String mul = hexCalc.multiply(hexNum1, hexNum2);
				System.out.println("Multilication is: " + mul);
				break;
			
			case 4:
				// calculating devision of hex numbers
				String dev = hexCalc.devide(hexNum1, hexNum2);
				System.out.println("Devision is: " + dev);
				break;
			
			case 5:
				// check for equal of hex strings
				boolean isEqual = hexCalc.isEqual(hexNum1, hexNum2);
				System.out.println("is equal? " + isEqual);
				break;

			case 6:
				// check weather first string is greater than second or not
				boolean isGreater = hexCalc.isGreater(hexNum1, hexNum2);
				System.out.println("is greater? " + isGreater);
				break;

			case 7:
				// check weather first string is lesser than second or not
				boolean isLesser = hexCalc.isLesser(hexNum1, hexNum2);
				System.out.println("is lesser? " + isLesser);
				break;

			}

		}
		sc.close();
	}

}
