package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionFactory;

@WebServlet("/UpdateEmployeeDetails")
public class UpdateEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateEmployeeDetails() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     	
     // creating connection and inserting data into database
     	Connection connection = null;
     	try 
     	{
    		
    		String fullName = request.getParameter("fullName");
         	String gender = request.getParameter("gender");
         	String email = request.getParameter("email");
         	String password = request.getParameter("password");
         	long  contact = Long.parseLong(request.getParameter("contact"));
         	String organizationName = request.getParameter("organizationName");
         	
			connection = ConnectionFactory.getConnection();
			

			PrintWriter out = response.getWriter();
			
			String query = "update employee set fullName= '" + fullName + "', " + "gender='" + gender + "', password = '" + password + "', contact = " + contact + ", organization = '" + organizationName + "' where email = '" + email + "';";
			
			System.out.println("query: " + query);
			
			Statement stmt = connection.createStatement();

			System.out.println("email: " + email);
			System.out.println("fullName: " + fullName);
			
			
				stmt.executeUpdate(query);
				
				String query1 = "select empId from employee where email= '" + email + "'";
				ResultSet rs1 = stmt.executeQuery(query1);
				if(rs1.next())
				{
					out.print("<h1 align=\"center\" style=\"color:green\"> updated successfully!</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("vehicleForm.jsp");  
				    rd.include(request,response);  
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
				    request.getSession().setAttribute("errorMessage", "Unable to update data!");
					rd.forward(request,response);
				}
			
     	} 
     	catch (SQLException e) 
     	{
     		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
		    request.getSession().setAttribute("errorMessage", e.getMessage());
			rd.forward(request,response);
		}
     	catch (Exception e)
     	{
     		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
		    request.getSession().setAttribute("errorMessage", "unable to update data!");
			rd.forward(request,response);
		}
	}

}
