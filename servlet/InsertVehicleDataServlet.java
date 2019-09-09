package servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

/**
 * Servlet implementation class SaveVehicleServlet
 */
@WebServlet("/InsertVehicleDataServlet")
public class InsertVehicleDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertVehicleDataServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// /fetching data from session
    	String vehicleName = request.getParameter("vehicleName");
    	String vehicleType = request.getParameter("vehicleType");
    	String vehicleNumber = request.getParameter("vehicleNumber");
    	String employeeId = request.getParameter("employeeId");
    	String identification = request.getParameter("identification");
    	
    	Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			
			PreparedStatement  ps = connection.prepareStatement("insert into vehicle values(null, ?, ?, ?, ?, ?);");
			
			ps.setString(1, vehicleName);
			ps.setString(2, vehicleType);
			ps.setString(3, vehicleNumber);
			ps.setString(4, employeeId);
			ps.setString(5, identification);
			   
			HttpSession session = request.getSession(); 
			
			session.setAttribute("vehicleType", vehicleType);
			
			if(!ps.execute())
			{
				Statement st =connection.createStatement();
				ResultSet rs = st.executeQuery("select vehicleId from vehicle where vehicleNumber = '" + vehicleNumber + "';");
				rs.next();
				session.setAttribute("vehicleId", rs.getInt(1));
				
				System.out.println("vehicleId = : " + rs.getInt(1));
				
				RequestDispatcher rd= request.getRequestDispatcher("showPassPlans.jsp");
				rd.forward(request, response);
		
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		

		
			
    }


}
