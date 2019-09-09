package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ConnectionFactory;
import Dao.LoginDao;



@WebServlet("/Home")  
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
		try {

			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			String password = (String)session.getAttribute("password");
			
			
			if(LoginDao.isValid(email, password))
			{
				Connection con = ConnectionFactory.getConnection();
				String query = "SELECT * FROM employee "
						+ " WHERE email=\""+email+"\";";
				
				PreparedStatement st = con.prepareStatement(query);
		        
				ResultSet rs = st.executeQuery(query);

				rs.next();

				// setting the current session emp id
				session.setAttribute("empId", rs.getInt(1));

				String name = rs.getString(2),
						gender = rs.getString(3),
						contact = rs.getString(6),
						organization = rs.getString(7);
				
				out.print("<html><head><style>");
				out.print(".topnav {"
						+"  overflow: hidden;"
						+"  background-color: #333;}"
						
						+".topnav a {"
						+"  float: left;"
						+"  color: #f2f2f2;"
						+"  text-align: center;"
						+"  padding: 14px 16px;"
						+"  text-decoration: none;"
						+"  font-size: 17px;}"

						+".topnav a:hover {"
						+"  background-color: #ddd;"
						+"  color: black;}"

						+".topnav a.active {"
						+"  background-color: #4CAF50;"
						+"  color: white;}"
						
						+"#profile-container {"
						+ "position: absolute;"
						+ "right: 0px;"
						+ "top: 60px;"
						+ "background-color: white;}"
						
						
						+"#profile-container img{"
						+ "position: relative;"
						+ "right: 0px;"
						+ "top: 0px;"
						+ "background-color: white;"
						+ "width: 120;"
						+ "height: 150}"
						
						+"#profile-container button{"
						+ "postion:relative;"
						+ "top:200px;"
						+ "right:0px}"
						
						+ ".logoutLblPos{"
						+ "position:fixed;"
						+"right:10px;}"
						
						+"</style>");
				
				System.out.println("rs.getInt(1) " + rs.getInt(1));
//				navbar content
				out.print("<div class='topnav' name='topnav'>"
						+ "<a  href='#home'>Home</a>"
						+ "<a href='friends?empId="+rs.getInt(1)+"'>Friends</a>"
						+ "<a class=\"logoutLblPos\" href='LogOutServlet'>log Out </a>"
						+ "</div>"
						+ "<br/>");
				out.print("<div id='profile-container' '>");
				
//				profile content
				
				if(gender.equals("male")){
					out.print("<img src='"+ request.getContextPath() +"/images/default-profile-picture.jpg' alt='image'/>");
				}
				else{
					out.print("<img src='"+ request.getContextPath() +"/images/user_profile_female.jpg' alt='image'/>");
				}
				
				out.print("<button type=button  onclick='#'>change</button>"
						+"</div>");
				
//				employee information
				
				out.println("<body><h1>Welcome !<br/> "+name+"</h1><br/><br/>");
				out.print("<p>gender: "+gender+"<br/>");
				out.print("<p>contact: "+contact+"<br/>");
				out.print("<p>organization: "+organization+"</p><br/><br/>");
				
//				update employee details
				
				out.print("<button type=button onclick=\"window.location.href = 'update.jsp'\">Edit</button><br/><br/>");
				
				out.print("<button type=button onclick=\"window.location.href = 'vehicleForm.jsp'\">"
						+ "Add New Vehicle</button>");
			
				out.print("</body>");
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
			    session.setAttribute("errorMessage", "you are not authorized");
				rd.forward(request,response);  
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
