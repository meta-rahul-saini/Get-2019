

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UpdateServlet updates the data inside the database updates provided by the user
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//getting the student data passed from user
		
		 int id = Integer.parseInt(request.getParameter("id")); 
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String fatherName = request.getParameter("fatherName");
		 String email = request.getParameter("email");
		 int age = Integer.parseInt(request.getParameter("age"));

		// crreating a connection 
		Connection connection = null;
		try 
		{
			connection = ConnectionFactory.getConnection();
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
					

		try 
		{

			Statement stmt = connection.createStatement();
						
			boolean isUpdated = stmt.execute("update student set firstName = '" + firstName + "',lastName='" + lastName + "', fatherName = '" + fatherName +"',email='"+email+"', age='"+age+"' where id = " + id );
						
			PrintWriter out = response.getWriter();
						
			if(!isUpdated)
			{
			out.println("<html> <body><h1> Successfully updated Student data!!!</h1></body></html>");
			}
			else
			{
			throw new AssertionError("error occured while updating data");
			}
		} 
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		}
		finally
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
	}

}
