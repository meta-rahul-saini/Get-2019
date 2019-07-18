package Marksheet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MarksheetMainControllerClass {

	public static void main(String[] args) {

		Marksheet marksheet = new Marksheet();
		int choice = 0;
		float averageGrade = 0;
		float maxGrade =0;
		float minGrade = 0;
		float percentageOfStudentPassed=0;
		boolean error = true;
		int noOfStudents = 0;
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		// get no. of students
		while (flag == true) {
			sc = new Scanner(System.in);
			System.out.println("Enter no. of Students");
			try {
				noOfStudents = sc.nextInt();

				if (noOfStudents < 0) {
					System.out.println("Please enter a valid positive integer");
				} else {
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("Please enter a valid positive integer");
			}

		}
		
		// adding grades for each student
		marksheet.inputStudentGrades(noOfStudents);

		flag = true;
		while (flag == true) {

			// show options
			System.out.println("1. Average value of all grades");
			System.out.println("2. Maximum of all grades");
			System.out.println("3. Minimum of all grades");
			System.out
					.println("4. percentage of students passed.");
			System.out.println("5. Exit");

			// get user's choice
			error = true;
			do {
				try {
					System.out.println("Enter your choice:\n");
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					if (choice < 1 | choice > 5) {
						System.out.println("Please Enter a valid positive integer");
						error = true;
					} else {
						error = false;
						if (choice == 5) {
							System.out.println("Exiting System");
							System.exit(0);
						}
					}
				} catch (InputMismatchException e) {
					System.out
							.println("Input Mismatch Exception occured. Please Enter a valid Positive Integer");
				}
			} while (error == true);
			
			switch (choice) {
			case 1:
				// averageGrade of students
				averageGrade = marksheet.averageGrade();
				System.out.println("Average Grade of Student is: "
						+ averageGrade);
				break;
			case 2:
				// maximum grade
				maxGrade = marksheet.maxGrade();
				System.out.println("Maximum Grade is: " + maxGrade);
				break;
			case 3:
				// minimum grade
				minGrade = marksheet.minGrade();
				System.out.println("Minimum Grade is: " + minGrade);
				break;
			case 4:
				// percentage of students passed
				percentageOfStudentPassed = marksheet
						.percentageOfStudentPassed();
				System.out.println("percentage of students passed: "
						+ percentageOfStudentPassed);
				break;
			case 5:
				// exit
				flag = false;
				System.out.println("Exit: ");
				break;
			}

		}
	}
}
