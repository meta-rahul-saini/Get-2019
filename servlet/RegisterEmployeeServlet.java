package servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Dao.ConnectionFactory;
import Dao.LoginDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterEmployeeServlet
 */
@WebServlet("/RegisterEmployeeServlet")
public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterEmployeeServlet() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String fullName = request.getParameter("fullName");
     	String gender = request.getParameter("gender");
     	String email = request.getParameter("email");
     	String password = request.getParameter("password");
     	String contact = request.getParameter("contact");
     	String organizationName = request.getParameter("organizationName");
        
     	// creating connection and inserting data into database
     	Connection connection = null;
     	try 
     	{
			connection = ConnectionFactory.getConnection();
			
			Statement stmt = connection.createStatement();

			PrintWriter out = response.getWriter();
			
			String insertDataQuery = "insert into employee values(null, \""+ fullName + "\", \"" + gender + "\", \"" + email + "\", \"" + password + "\", \"" + contact + "\", \"" + organizationName + "\");";
			
			System.out.println("email: " + email);
			
			if(LoginDao.isRegistered(email))
			{
				request.getSession().setAttribute("errorMessage", "already Registered");
				response.sendRedirect("error.jsp");
			}
			else
			{
				stmt.execute(insertDataQuery);
				
				request.getSession().setAttribute("email", email);
				request.getSession().setAttribute("password", password);
				
				String fetchEmpIdQuery = "select empId from employee where email= '" + email + "'";
				
				ResultSet rs1 = stmt.executeQuery(fetchEmpIdQuery);
				
				rs1.next();
				
				int empId = rs1.getInt("empId");
				
				System.out.println("empId: " + empId);
				
				// setting the empID attribute in session
				
				request.getSession().setAttribute("empId", empId);
				
//				request.setAttribute("empId", empId);
				
				out.print("<h1 align=\"center\" style=\"color:green\"> You have successfully registered!</h1>");
				
				// forward the request to vehicle form 
				RequestDispatcher rd=request.getRequestDispatcher("vehicleForm.jsp");  
			    
				rd.include(request,response);  
			}
			
     	} 
     	catch (SQLException e) 
     	{
			e.printStackTrace();
		}
     	
    }

}
