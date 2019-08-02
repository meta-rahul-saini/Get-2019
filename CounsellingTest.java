import java.io.File;
import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**this function contains the methods for testing the counselling program
 * @author rahul
 *
 */
public class CounsellingTest {
	
	 /**method to import allocated programs to the students
	 * @return, array o allocated programs
	 */
	public int[] importAllocatedProgramsToStudents()
		{
			Cell[] row;
			Workbook workbook = null;
			int totalStudent = 0;
			int studentAllocatedPrograms[] = null;
			String counselResult = "D:\\counselResult.xls";
			
			  try {
		        	try
		        	{
		        		workbook = Workbook.getWorkbook(new File(counselResult));
		        	}
		        	catch(java.io.FileNotFoundException e)
		        	{
		        		e.printStackTrace();
		        	}
		            
		        	Sheet sheet = workbook.getSheet(0);
		            
		        	totalStudent = sheet.getRows();
		            
		        	// if file is empty throw Assertion error
		        	if(totalStudent < 1)
		        	{
		            	throw new AssertionError("empty student file.");
		            }
		            
		        	System.out.println(totalStudent);
		            
		        	// creating a student Queue
		        	studentAllocatedPrograms = new int[totalStudent];
		            
		        	for (int currentStudentIndex = 0; currentStudentIndex < totalStudent; currentStudentIndex++)
		        	{
		        		// getting current row content
		        		
		        		row = sheet.getRow(currentStudentIndex);
		        		
						// getting the programId of allocatd programs to the student
						
		        		studentAllocatedPrograms[currentStudentIndex] = Integer.parseInt(row[3].getContents());
		            }
			            
		        }

			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  } 
			  catch (BiffException e) 
			  {
				  e.printStackTrace();
			  }
			  finally 
			  {
				 if (workbook != null) 
				 {
					 workbook.close();
				 }
			  }
			  workbook = null;
			  return studentAllocatedPrograms;
		 	}
	
	@Test
	 public void testAllocateProgramsToStudentWhenWePassValidData(){
		
		String studentData = "D:\\studentData.xls",
				 programList = "D:\\programList.xls",
				 result = "D:\\counselResult.xls";
		 
		 Counselling counselling = new Counselling(studentData, programList, result);
		 
		 counselling.allocateProgramsToStudents();
		 
		 int expectedOutputArray[] = {1, 1, 7, 2, 9, 10, 11, 5, 8, 4, 5, 4, 3, 6, 10}; 
		 int computedOutputArray[] = importAllocatedProgramsToStudents();
		 
		 assertArrayEquals(expectedOutputArray, computedOutputArray);
}
}