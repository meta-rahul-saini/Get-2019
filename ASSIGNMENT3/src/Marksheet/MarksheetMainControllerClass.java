package Marksheet;

import java.util.ArrayList;
import java.util.Scanner;

public class MarksheetMainControllerClass {

	public static ArrayList<Integer> studentGrades = new ArrayList<>();

	// display options to the user
	public static void displayOptions() {

		System.out.println("1. Average value of all grades");

		System.out.println("2. Maximum of all grades");

		System.out.println("3. Minimum of all grades");

		System.out
				.println("4. percentage of students passed. (Assume grade >= 40 as Pass");

		System.out.println("5. Exit");

	}

	public static void main(String[] args) {

		Marksheet marksheet = new Marksheet();

		int noOfStudents = 0;
		int grade = 0;
		System.out.println("Eneter no. of students");
		Scanner sc = new Scanner(System.in);

		// takes no. of students from user
		try {
			noOfStudents = sc.nextInt();
			if (noOfStudents < 0) {
				sc.close();
				throw new Exception("Please Enter a Positive Integer");
				
			}
		} catch (Exception e) {
			
			System.out.println("Please Enter a Positive Integer");
			System.exit(0);
			
		}

		// adding grades
		for (int studentCount = 1; studentCount <= noOfStudents; studentCount++) {
			System.out.println("Enter Grade for student : " + studentCount);
			try {
				grade = sc.nextInt();
				if (grade < 0 & grade > 100) {
					throw new Exception("Please Enter a valid Positive Integer");
				}
			} catch (Exception e) {
				System.out.println("Please Enter a valid positive Integer");
				System.exit(0);
				break;
			}

			studentGrades.add(grade);
		}

		boolean flag = true;
		int choice = 0;
		while (flag == true) {
			displayOptions();
			System.out.println("Enter your choice:\n");
			try {
				choice = sc.nextInt();
				if (choice < 0) {
					throw new Exception("please enter valid choice");
				}
			} catch (Exception e) {
				System.out
						.println("Please Enter a valid Positve Integer choice");
			}

			switch (choice) {
			case 1: {

				// averageGrade of students
				float averageGrade = marksheet.averageGrade(studentGrades);

				System.out.println("Average Grade of Student is: "
						+ averageGrade);

				break;
			}

			case 2: {

				// maximum grade

				float maxGrade = marksheet.maxGrade(studentGrades);

				System.out.println("Maximum Grade is: " + maxGrade);

				break;
			}
			case 3: {

				// minimum grade

				float minGrade = marksheet.minGrade(studentGrades);

				System.out.println("Minimum Grade is: " + minGrade);

				break;
			}
			case 4: {

				// percentage of students passed

				float percentageOfStudentPassed = marksheet
						.percentageOfStudentPassed(studentGrades);

				System.out.println("percentage of students passed: "
						+ percentageOfStudentPassed);

				break;
			}
			case 5: {

				// exit
				flag = false;
				System.out.println("Exit: ");

				break;
			}
			}

		}

		sc.close();
	}
}
