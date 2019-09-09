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
import javax.servlet.http.HttpSession;

import Dao.ConnectionFactory;
import Dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();

		if (LoginDao.isValid(email, password)) {
			Connection connection = null;

			connection = ConnectionFactory.getConnection();

			Statement stmt = null;
			try {

				stmt = connection.createStatement();

				out.print("<h1 align=\"center\" style=\"color:red\"> You are already registered!</h1>");
				
				// response.sendRedirect("FetchEmployeeData?ema");
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("password", password);

				String fetchEmpIdQuery = "select empId from employee where email= '"
						+ email + "'";

				ResultSet rs1;

				rs1 = stmt.executeQuery(fetchEmpIdQuery);

				rs1.next();

				int empId = rs1.getInt("empId");

				// setting the empID attribute in session
				request.getSession().setAttribute("empId", empId);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("inside validated close");
			RequestDispatcher rd = request.getRequestDispatcher("Home");

			rd.forward(request, response);// method may be include or forward
		} else {
			System.out.println("inside not  validated close");
			out.print("<h1 style=\"color:red;\"> Inalid Authentication!!</h1>");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}

	}

}
