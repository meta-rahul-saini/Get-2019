<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.Connection, java.io.PrintWriter, java.sql.Statement, java.sql.ResultSet, javax.servlet.http.HttpSession, Dao.LoginDao"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="main.js"></script>
<title>Insert title here</title>
</head>
<body align = center>


            <h1>Add Vehicle</h1><hr><br><br>
            <form id = "vehicleInformation" action="InsertVehicleDataServlet">
                
                Name:
                <input type="text" id="vehicleName" name="vehicleName" minlength="2" required><br><br>

                Type:
                <select id="vehicleType" name="vehicleType">
                    <option id = "cycle" value="cycle">cycle</option>
                    <option id = "twoWheeler" value="twoWheeler">two Wheeler</option>
                    <option id = "fourWheeler" value="fourWheeler">Four Wheeler</option>
                </select><br><br>

                Vehicle Number:
                <input type="text" id="vehicleNumber" name="vehicleNumber" pattern="[A-Z]{2}[0-9]{2}[A-Z0-9]{2}[0-9]{4}" placeholder="RJ14AA0000" required><br><br>

				<%
				HttpSession session2 = request.getSession();
				String email = (String)session2.getAttribute("email");
				String password = (String)session2.getAttribute("password");
				if(!LoginDao.isValid(email, password))
				{
					RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
    			    session.setAttribute("errorMessage", "you are not authorized");
    				rd.forward(request,response);  
				}
				Integer empId = (Integer)request.getSession().getAttribute("empId");
				
				System.out.println("empId: " + empId);
				
				%>
				
                Employee Id  
                <input type="text" id="employeeId" name= "employeeId" value = "<%=empId%>" readonly="readonly" ><br><br>


                Identification:
                <textarea rows="2" id= "identification" name="identification" cols="50">
                </textarea><br><br>

                <input type="submit"/>
                <input type="reset">

            </form>
        </div> <br><br>
        
</body>
</html>