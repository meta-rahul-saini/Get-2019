


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *this servlet handles the request to add the student to student database
 */
public class AddStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public AddStudentServlet() {
       super();
   	}

    
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		 // getting data from user
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String fatherName = request.getParameter("fatherName");
		 String email = request.getParameter("email");
		 int age = Integer.parseInt(request.getParameter("age"));
		 int class1 = Integer.parseInt(request.getParameter("class"));
		 
		 
		// creating a connection 
			Connection connection = null;
			try 
				{
					connection = ConnectionFactory.getConnection();
				} catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				}
			

			try {

				// creating a statement vehicle 
				Statement stmt = connection.createStatement();

				// inserting student data inside student table
				stmt
						.execute("insert into student values(null,'" 
				+  firstName 
				+ "','" + lastName 
				+ "','" + fatherName 
				+ "','" + email 
				+ "','" + class1 
				+ "','" + age + "')");

				PrintWriter out = response.getWriter();
				
				// sending response to the user
				out.print("<h1> Student is successfully added!!</h1>");
				
			} 
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
				throw new AssertionError("not able to execute query");
			}
			finally
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}


}
