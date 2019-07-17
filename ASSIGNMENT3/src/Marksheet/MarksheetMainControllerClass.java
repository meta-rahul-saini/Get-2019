package Marksheet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MarksheetMainControllerClass {

	private static ArrayList<Integer> studentGrades = new ArrayList<>();

	// display options to the user
	public static void displayOptions() {
		System.out.println("1. Average value of all grades");
		System.out.println("2. Maximum of all grades");
		System.out.println("3. Minimum of all grades");
		System.out
				.println("4. percentage of students passed. (Assume grade >= 40 as Pass");
		System.out.println("5. Exit");
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
		return choice;
	}

	/**
	 * we use this function for taking input grades of each student
	 */
	public static void inputStudentGrades() {
		int grade = 0;
		int noOfStudents = getNoOfStudents();
		for (int currentStudent = 1; currentStudent <= noOfStudents; currentStudent++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Grade for student : " + currentStudent);
			try {
				grade = sc.nextInt();
				if (grade < 0 | grade > 100) {
					throw new Exception("Please Enter a valid Positive Integer");
				}
			} catch (Exception e) {
				System.out
						.println("Please Enter a valid positive Integer Grade");
				currentStudent--;
			}
			studentGrades.add(grade);
		}
	}

	/**
	 * @return returns no of students
	 */
	public static int getNoOfStudents() {

		int noOfStudents = 0;
		boolean flag = true;
		Scanner sc;
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
		return noOfStudents;
	}

	public static void main(String[] args) {

		Marksheet marksheet = new Marksheet();
		int choice = 0;
		float averageGrade = 0;
		float maxGrade =0;
		float minGrade = 0;
		float percentageOfStudentPassed=0;

		// adding grades
		inputStudentGrades();

		boolean flag = true;
		
		while (flag == true) {

			displayOptions();

			choice = getChoice();

			switch (choice) {
			case 1:
				// averageGrade of students
				averageGrade = marksheet.averageGrade(studentGrades);
				System.out.println("Average Grade of Student is: "
						+ averageGrade);
				break;
			case 2:
				// maximum grade
				maxGrade = marksheet.maxGrade(studentGrades);
				System.out.println("Maximum Grade is: " + maxGrade);
				break;
			case 3:
				// minimum grade
				minGrade = marksheet.minGrade(studentGrades);
				System.out.println("Minimum Grade is: " + minGrade);
				break;
			case 4:
				// percentage of students passed
				percentageOfStudentPassed = marksheet
						.percentageOfStudentPassed(studentGrades);
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
