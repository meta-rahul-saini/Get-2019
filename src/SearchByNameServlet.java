

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

/**
 * SearchByNameServlet handles the request to search students by name and dynamically generates html page response
 */
@WebServlet("/SearchByNameServlet")
public class SearchByNameServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public SearchByNameServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchTerm = request.getParameter("searchTerm");
		String searchTerms[] = searchTerm.split("\\s+");
		
		String query = null;
		
		if(searchTerms.length == 1)
		{
			query = "select * from student where firstName like '%"+ searchTerms[0] + "%' || " + " lastName like '%" + searchTerms[0] + "%'" ;
		}
		else
		{
			query = "select * from student where firstName like '%"+ searchTerms[0] + "%' && " + " lastName like '%" + searchTerms[1] + "%'" ;
			
		}
		// crreating a connection
		Connection connection = null;
		try {
				connection = ConnectionFactory.getConnection();
			} catch (ClassNotFoundException e1) 
			{
					e1.printStackTrace();
			}

		try {
				// creating a statement vehicle
				Statement stmt = connection.createStatement();

				// executing query
				ResultSet rs = stmt.executeQuery(query);

				PrintWriter out = response.getWriter();
				
				// generating dynamic html web page response
				out.println("<html><body><table  align=\"center\" style=\"border:1px solid black\" border=\"1\">");
				out.println("<tr> <th>id</th> <th>first name </th> <th> last name </th> <th> father name </th> <th> email </th> <th> class </th> <th> age </th>");
				
				while (rs.next()) 
				{
						out.println("<tr>");
						out.println("<td>" + rs.getString(1) + "</td>");
						out.println("<td>" + rs.getString(2) + "</td>");
						out.println("<td>" + rs.getString(3) + "</td>");
						out.println("<td>" + rs.getString(4) + "</td>");
						out.println("<td>" + rs.getString(5) + "</td>");
						out.println("<td>" + rs.getString(6) + "</td>");
						out.println("<td>" + rs.getString(7) + "</td>");
						out.println("</tr>");
				}
					out.println("</table><body></html>");

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
						System.out.println();
				}
			}
		
	}

}
