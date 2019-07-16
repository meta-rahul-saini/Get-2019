package StringOperations;
import java.util.Scanner;

public class StringOperationsMainControllerClass {

	// display options to the user
	public static void displayOptions() {

		System.out.println("1. compare strings");

		System.out.println("2. reverse of string");

		System.out.println("3. Swap Case of strings");

		System.out.println("4. Exit");

	}

	public static void main(String[] args) {

		StringOperations stringOperations = new StringOperations();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		int choice = 0;
		while (flag == true) {
			displayOptions();
			System.out.println("Enter your choice:\n");
			try {
				choice = sc.nextInt();
				if (choice < 0 && choice > 5) {
					throw new Exception("please enter valid choice");
				}
			} catch (Exception e) {
				System.out
						.println("Please Enter a valid Positve Integer choice");
			}

			switch (choice) {
			case 1: {

				// compare strings

				System.out.println("Enter first String");
				String str1 = sc.next();
				System.out.println("Enter second String");
				String str2 = sc.next();

				int isEqual = stringOperations.isEqual(str1, str2);

				if (isEqual == 1) {
					System.out.println("Strings are equal");
				}

				else {
					System.out.println("Strings are not equal");
				}

				break;
			}
			
			case 2: {

				// Reverse of String

				System.out.println("Enter String");
				String str1 = sc.next();
				
				String revStr = stringOperations.reverse(str1);

				System.out.println("Reverse of String is: " + revStr);

				break;
			}
			
			case 3: {
				
				// swapping of cases of string
				
				System.out.println("Enter String");
				String str1 = sc.next();
				
				String swappedCaseString = stringOperations.swapCase(str1);

				System.out.println("Swapped Case String is: " + swappedCaseString);

				break;
				
				
			}
			
			case 4: {
				flag = false;
				System.out.println("Exit:");
			}
			
			}
		}
		
		sc.close();
	}

}
