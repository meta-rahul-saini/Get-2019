package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.ConnectionFactory;
import Dao.LoginDao;

/**
 * Servlet implementation class IsRegisteredServlet
 */
@WebServlet("/IsRegisteredServlet")
public class IsRegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IsRegisteredServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// creating connection and inserting data into database
     Connection connection = null;
     try 
     {
		
		connection = ConnectionFactory.getConnection();
		
		Statement stmt = connection.createStatement();
		
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		
		ResultSet rs = stmt.executeQuery("select id from employee where email = \"" + email + "\";");
	
		while(rs.next())
		{
			out.println("<h1> Registration id is: " + rs.getString("id") + "</h1>");
		}
     }
     catch (SQLException e) 
  	{
			e.printStackTrace();
		}
	}
}
