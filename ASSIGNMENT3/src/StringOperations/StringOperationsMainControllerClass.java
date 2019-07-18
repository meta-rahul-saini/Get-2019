package StringOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringOperationsMainControllerClass {

	public static void main(String[] args) {

		StringOperations stringOperations = new StringOperations();
		Scanner sc = new Scanner(System.in);
		String string1 = "";
		String string2 = "";
		int choice = 0;
		boolean error = true;

		boolean flag = true;

		while (flag == true) {
			// display option to choose from
			System.out.println("1. compare strings");

			System.out.println("2. reverse of string");

			System.out.println("3. Swap Case of strings");

			System.out.println("4. find largest word in string");

			System.out.println("5. Exit");

			// get users choice
			error=true;
			do {
				try {
					System.out.println("Enter your choice:\n");
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					if (choice < 1 | choice > 4) {
						System.out
								.println("Please Enter a valid positive integer");
						error = true;
					} else {
						error = false;
					}
				} catch (InputMismatchException e) {
					System.out
							.println("Input Mismatch Exception occured. Please Enter a valid Positive Integer");
				}

			} while (error == true);

			switch (choice) {
			case 1:
				// compare strings
				System.out.println("Enter first String");
				string1 = sc.next();
				System.out.println("Enter second String");
				string2 = sc.next();
				int isEqual = stringOperations.isEqual(string1, string2);
				if (isEqual == 1) {
					System.out.println("Strings are equal");
				} else {
					System.out.println("Strings are not equal");
				}
				break;

			case 2:
				// Reverse of String
				System.out.println("Enter String");
				string1 = sc.next();
				String reverseString = stringOperations.reverse(string1);
				System.out.println("Reverse of String is: " + reverseString);
				break;

			case 3:
				// swapping of cases of string
				System.out.println("Enter String");
				string1 = sc.next();
				String swappedCaseString = stringOperations.swapCase(string1);
				System.out.println("Swapped Case String is: "
						+ swappedCaseString);
				break;
			case 4:
				
				// find largest word of string
				System.out.println("Enter String");
				sc = new Scanner(System.in);
				string1 = sc.nextLine();
				String largestWord = stringOperations.findLargestWord(string1);
				System.out.println("Largest Word: "+ largestWord);
				break;
			case 5:
				flag = false;
				System.out.println("Exit:");

			}
		}
		sc.close();
	}

}
