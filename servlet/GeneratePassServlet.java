package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ConnectionFactory;

/**
 * Servlet implementation class GeneratePassServlet
 */
@WebServlet("/GeneratePass")
public class GeneratePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GeneratePassServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
        
        System.out.println(" INSIDE GENERATE PASSSSSSSSSSSSS");
		try {
			
			// fetch the request parametsrs
			HttpSession session = request.getSession();
			System.out.println(session.getAttribute("empId")); 
			int empId =Integer.parseInt("" + session.getAttribute("empId"));
			String currencyName = request.getParameter("currencyName");
			String vehicleType = (String)(request.getSession().getAttribute("vehicleType"));
			String plan = request.getParameter("plan");
			
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
			String fetchAmountQuery = "select " + plan + " from priceList where vehicleType = '" + vehicleType + "';";
			
			ResultSet rs = st.executeQuery(fetchAmountQuery);
			
			rs.next();
			float amount = rs.getFloat(1);
			System.out.println("amount: " + amount);
			
			// inserting the pass data 
			PreparedStatement st2 = con.prepareStatement("insert into PassDetail values(null, ?, ?, ?, now(), ?);");
			
			st2.setInt(1, empId);
			st2.setFloat(2, amount);
			st2.setString(3, plan);
			st2.setInt(4, (int)(session.getAttribute("vehicleId")));
			
			st2.execute();
			st2.close();
			con.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("Home");  
			rd.forward(request,response);  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
