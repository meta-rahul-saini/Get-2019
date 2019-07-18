package Marksheet;
import java.util.ArrayList;
import java.util.Scanner;

public class Marksheet {
	
	private static ArrayList<Integer> studentGrades = new ArrayList<>();

	public static ArrayList<Integer> getStudentGrades() {
		return studentGrades;
	}


	public static void setStudentGrades(ArrayList<Integer> studentGrades) {
		Marksheet.studentGrades = studentGrades;
	}

	
	/** inputs student grades for each student, given no. of students
	 * @param noOfStudents, no of students in marksheet
	 */
	public void inputStudentGrades(int noOfStudents) {
		int grade = 0;
		for (int currentStudent = 1; currentStudent <= noOfStudents; currentStudent++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Grade for student : " + currentStudent);
			try {
				grade = sc.nextInt();
				if (grade < 0 | grade > 100) {
					throw new Exception("Please Enter a valid Positive Integer");
				}
				else{
					studentGrades.add(grade);
				}
			
			} catch (Exception e) {
				System.out
						.println("Please Enter a valid positive Integer Grade");
				currentStudent--;
			}
		}
	}

	
	/**returns average grades or students
	 * @return, average grades of students
	 */
	public float averageGrade()
	{
		float sumOfStudentGrades = 0;
		
		// computing sum of all student's grade
		for (int studentGrade: studentGrades)
		{
			sumOfStudentGrades +=studentGrade;  
		}
	
		// find average of students grade
		if(studentGrades.size()==0)
		{
			return 0;
		}
		float averageGrade = sumOfStudentGrades/ (float)(studentGrades.size());
		return averageGrade;
		
	}

	/** returns maximum grade of students
	 * @return, maxGrade of students
	 */
	public float maxGrade()
	{
		float maxGrade = 0;
		
		// computing sum of all student's grade
		for (int studentGrade: studentGrades)
		{
			if(maxGrade < studentGrade)
			{
				maxGrade = studentGrade;
			}
		}
		return maxGrade;
		
	}
	
	
	/**
	 * @param studentGrades is the grades of all students
	 * @return minGrade of all students
	 */
	public float minGrade()
	{
		float minGrade = 101;
		
		// computing sum of all student's grade
		for (int studentGrade: studentGrades)
		{
			if(minGrade > studentGrade)
			{
				minGrade = studentGrade;
			}
		}
		
		// find average of students grade
		return minGrade;
		
	}
	
	
	/**
	 * @param studentGrades is the grades of all students
	 * @return percentage of students passed.
	 */
	public float percentageOfStudentPassed(){
		int noOfStudentPassed = 0;
		
		// computing no. of student passed
		for (int studentGrade: studentGrades)
		{
			if(studentGrade>=40)
				noOfStudentPassed+=1;
		}
		
		
		int totalNoOfStudents = studentGrades.size();
		
		// percentage of student passed
		float percentageStudentsPassed = ((float)noOfStudentPassed)/ ((float) totalNoOfStudents)*100;

		return percentageStudentsPassed;
	}
	
}
