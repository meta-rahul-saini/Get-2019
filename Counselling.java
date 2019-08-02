import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Counselling 
{
	
	 private String studentData;
	 private String programList;
	 private String counselingResult;
	 private int totalStudent;
	 private int totalProgram;
	 private StudentQueue studentQueue;
	 private Program[] progList;
	 private Workbook workbook = null;
	 private WritableWorkbook counselResultWBook = null;
	
	 
	 /**constructor to initialize the path from where to read data
	 * @param studentData
	 * @param programList
	 * @param result
	 */
	Counselling(String studentData, String programList, String result)
	 {
		 this.studentData = studentData;
		 this.programList = programList;
		 this.counselingResult = result;
	 }
	 
	 
	 /** this function is used to import student data from x-cel files
	 * @param studentList
	 * @return list of students
	 */
	public StudentQueue importStudentData()
	{
		Cell[] row;
		String name;
		int rank;
		int[] prefOrder;
		int count = 0;
		Student studentObject = null;
		  try {
	        	try
	        	{
	        		workbook = Workbook.getWorkbook(new File(studentData));
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
	        	studentQueue = new StudentQueue(totalStudent);
	            
	        	for (int currentStudentIndex = 0; currentStudentIndex < totalStudent; currentStudentIndex++)
	        	{
	        		// getting current row content
	        		row = sheet.getRow(currentStudentIndex);
					
	        		prefOrder = new int[5];
					
	        		// getting the name of student
					name = row[0].getContents();
					
					// getting the rank of student
					rank = Integer.parseInt(row[1].getContents());
					
					// getting the user preferred list of program 
					
					String[] order = row[2].getContents().split(",");
					
					// initializing the list of program preferred by user
					for(count = 0; count < 5; count++)
					{
						System.out.println(" pre order: " + order[count]);
						prefOrder[count] = Integer.parseInt(order[count].trim());
					}
					//System.out.println(name);
					studentObject = new Student(name,rank,prefOrder);
					
					// adding the student to queue
					studentQueue.enqueue(studentObject);
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
		  return studentQueue;
	 	}
	 
	 /**
	 * @param progList
	 * @return list of program
	 */
	public Program[] importProgramList()
	{
		Cell[] row;
		String name;
		int id = 0;
		int capacity = 0;
		
		 try
		 {
         	this.workbook = Workbook.getWorkbook(new File(this.programList));
         }
         catch(java.io.FileNotFoundException e)
		 {
         	e.printStackTrace();
         }
		 catch (BiffException e) 
		 {
			e.printStackTrace();
		 }
		 catch (IOException e) 
		 {
			e.printStackTrace();
		 }
         
		 Sheet programSheet = workbook.getSheet(0);
         
         totalProgram = programSheet.getRows();
         
         if(totalProgram < 1)
         {
         	throw new AssertionError("empty student file.");
         }
         progList = new Program[totalProgram];
         
         for (int currentProgramIndex = 0; currentProgramIndex < totalProgram; currentProgramIndex++) 
         {
				
        	 row = programSheet.getRow(currentProgramIndex);
				
				name = row[0].getContents();

				id = Integer.parseInt(row[1].getContents());
				
				capacity = Integer.parseInt(row[2].getContents());
				
				progList[currentProgramIndex] = new Program(name,id,capacity);
				
			}
         return progList;
	 }
	 
	
	/**we use this function to allocate programs to student
	 * @param studentList
	 * @param progList
	 * create excel sheet
	 */
	public void allocateProgramsToStudents()
	{
		studentQueue = importStudentData();
		
		progList = importProgramList();
	
		//writing the alloted program directly in excel sheet
        
		try
		{
        
			this.counselResultWBook = Workbook.createWorkbook(new File(this.counselingResult));
	        
			WritableSheet excelSheet = this.counselResultWBook.createSheet("Sheet 1", 0);
			
	        int row = 0;
	        Student student = null;
	        int[] prefProgramList;
	        int preferredProgramIndex;
	        int currentProgramIndex;
	        int progId = 0;
	        boolean flag = false;
	        Label label = null;
	        Label pref = null;
	        Number progIdNumeber;
	        Number rank;

        	int studentCount = 0;
	        while(!studentQueue.isEmpty())
	        {
	            // getting the student oject 
	        	student = studentQueue.peep();
	        	// taking the student preferred choices
	            prefProgramList = student.prefrenceOrder();
	            
	            studentCount++;
	            
	            for(preferredProgramIndex = 0; preferredProgramIndex < 5; preferredProgramIndex++)
	            {
	            		 for (currentProgramIndex = 0; currentProgramIndex < totalProgram; currentProgramIndex++)
	            		 {
	            			progId = progList[currentProgramIndex].getProgramId();
	            			
	            			System.out.println(" student count: " + studentCount);
	            			System.out.println(" pref program: "+ prefProgramList[preferredProgramIndex] + " program ID: " + progId );
	            			if(prefProgramList[preferredProgramIndex] == progId)
	            			{
	 	            			if(progList[currentProgramIndex].isAvailable())
	 	            			{
	 	            				progList[currentProgramIndex].setProgramCapacity(progList[currentProgramIndex].getProgramCapacity() - 1);
	 	            				System.out.println(" program " +currentProgramIndex + " capacity: " + (progList[currentProgramIndex].getProgramCapacity()) );
	 	            				
	 	            				student.setProgID(progId);
	 	            				flag = true;
	 	            			}
	 	            		}
	            			 if(flag == true)
	 	            		{
	 	 	            		break;
	 	 	            	}
	 	            	}
	            		 if(flag == true)
	            		 {
	            			 flag = false;
	            			 break;
	            		 }
	            }
	            
	            // it takes argument column index, row, and data
	            // adding name of the students in 1st column
	            label = new Label(0, row, student.getName());
	            
	            try
	            {
	                excelSheet.addCell((WritableCell) label);
	            }
	            catch(Exception e)
	            {
	                e.printStackTrace();
	            }
	            
	           // adding the rank of the students in 2nd column
	           rank = new Number(1, row, student.getRank());
	            
	            try{
	               excelSheet.addCell(rank);
	               }
	            catch(Exception e)
	            {
	                	 e.printStackTrace();
	            }
	            
	            // adding the user preferred choices to the 3rd column 
	            pref = new Label(2, row, Arrays.toString(student.prefrenceOrder()));
	                 try{
	                	 excelSheet.addCell(pref);
	                 }catch(Exception e){
	                	 e.printStackTrace();
	                 }
	            
	            // adding the user allocated program id to the 4th column
	            progIdNumeber = new Number(3, row, student.programId());
	                 try{
	                	 excelSheet.addCell(progIdNumeber);
	                 }catch(Exception e){
	                	 e.printStackTrace();
	                 }
	                 row++;
	            	 studentQueue.dequeue();
	            }
	           counselResultWBook.write();
	            
        }
        catch (IOException e) 
		{
            e.printStackTrace();
        }
        finally 
        {
            if (counselResultWBook != null) 
            {
                try 
                {
                	counselResultWBook.close();
                } catch (IOException e) 
                {
                    e.printStackTrace();
                } catch (WriteException e) 
                {
                    e.printStackTrace();
                }
            }
         }
	 }
	
	 public static void main(String[]args)
	 {
		 String studentData = "D:\\studentData.xls",
				 programList = "D:\\programList.xls",
				 result = "D:\\counselResult.xls";
		 
		 
		 Counselling counselling = new Counselling(studentData, programList, result);
		 
		 counselling.allocateProgramsToStudents();
	 
	 }
}
