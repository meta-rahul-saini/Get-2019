package StringOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringOperationsMainControllerClass {

	// display options to the user
	public static void displayOptions() {

		System.out.println("1. compare strings");

		System.out.println("2. reverse of string");

		System.out.println("3. Swap Case of strings");

		System.out.println("4. Exit");

	}

	// function to get choice from user

	public static int getChoice() {
		int choice = 0;
		boolean error = true;
		do {
			try {

				System.out.println("Enter your choice:\n");

				Scanner sc = new Scanner(System.in);

				choice = sc.nextInt();

				if (choice < 1 | choice > 4) {
					System.out.println("Please Enter a valid positive integer");
					error = true;
				} else {
					error = false;
				}

			} catch (InputMismatchException e) {
				System.out
						.println("Input Mismatch Exception occured. Please Enter a valid Positive Integer");
			}

		} while (error == true);

		return choice;
	}

	public static void main(String[] args) {

		StringOperations stringOperations = new StringOperations();
		Scanner sc = new Scanner(System.in);
		String str1 = "";
		String str2 = "";

		int choice = 0;

		boolean flag = true;

		while (flag == true) {
			// display option to choose from
			displayOptions();

			// get users choice
			choice = getChoice();

			switch (choice) {
			case 1:
				// compare strings
				System.out.println("Enter first String");
				str1 = sc.next();
				System.out.println("Enter second String");
				str2 = sc.next();
				int isEqual = stringOperations.isEqual(str1, str2);
				if (isEqual == 1) {
					System.out.println("Strings are equal");
				} else {
					System.out.println("Strings are not equal");
				}
				break;

			case 2:
				// Reverse of String
				System.out.println("Enter String");
				str1 = sc.next();
				String revStr = stringOperations.reverse(str1);
				System.out.println("Reverse of String is: " + revStr);
				break;

			case 3:
				// swapping of cases of string
				System.out.println("Enter String");
				str1 = sc.next();
				String swappedCaseString = stringOperations.swapCase(str1);
				System.out.println("Swapped Case String is: "
						+ swappedCaseString);
				break;
			case 4:
				flag = false;
				System.out.println("Exit:");

			}
		}
	}

}
