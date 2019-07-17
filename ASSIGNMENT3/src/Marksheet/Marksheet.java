package Marksheet;
import java.util.ArrayList;

public class Marksheet {
	
	/**
	 * @param studentGrades is the grades of all students
	 * @return averageGrade of all students
	 */
	public float averageGrade(ArrayList<Integer> studentGrades)
	{
		float sumOfStudentGrades = 0;
		
		// computing sum of all student's grade
		for (int studentGrade: studentGrades)
		{
			sumOfStudentGrades +=studentGrade;  
		}
	
		// find average of students grade
		float averageGrade = sumOfStudentGrades/ (float)(studentGrades.size());
		return averageGrade;
		
	}

	
	/**
	 * @param studentGrades is the grades of all students
	 * @return maxGrade of all students
	 */
	public float maxGrade(ArrayList<Integer> studentGrades)
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
	public float minGrade(ArrayList<Integer> studentGrades)
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
	public float percentageOfStudentPassed(ArrayList<Integer> studentGrades){
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
