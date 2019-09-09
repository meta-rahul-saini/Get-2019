package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.ConnectionFactory;



/**
 *this class used to show the list of friends of a friend
 */
@WebServlet("/friends")  
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
		try {
 
	        out.println("<h1>Friend List</h1>");
	        String empId = request.getParameter("empId");
			String fetchFriendsQuery = "SELECT * FROM FriendsList AS FL "
					+ " WHERE FL.empId=\""+empId+"\";";
			
			Connection con = ConnectionFactory.getConnection();
			
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			
			ResultSet rs1 = st1.executeQuery(fetchFriendsQuery);
	        
	       while(rs1.next()){
	    	   String friendDetails = "SELECT * FROM employee"
						+ " WHERE employee.empId="+rs1.getInt(2)+";";
	    	   System.out.println("friendList Id: " + rs1.getInt(1));
	    	   ResultSet rs2 = st2.executeQuery(friendDetails);
	    	   while(rs2.next())
	    	   {
	    		   out.println("<a href='showFriendDetail.jsp?friendId="+rs1.getString(2)+"'>"+ rs2.getString(2)+"</a>");
	    	   }
	       }
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
