<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, Dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="main.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<%! 
	String fullName = null;
 	String gender = null;
 	String email1 = null;
 	String password = null;
 	String contact = null;
 	String organizationName = null; 
	%>

	<%
		
    String email =  (String)session.getAttribute("email");

    
    
    Connection connection = null;
    
	try 
    {
	
    connection = ConnectionFactory.getConnection();
    
    System.out.println("connection reference: " + connection);
    
    Statement stmt = connection.createStatement();
    
    // fetching plans for the selected vehicleType

    String query = "select * from employee where email = '"+email+ "';";
    
    ResultSet rs = stmt.executeQuery(query);
    
    rs.next(); 
    
	fullName = rs.getString(2);
 	gender = rs.getString(3);
 	password = rs.getString(5);
 	contact = rs.getString(6);
 	organizationName = rs.getString(7);
 	
 	System.out.println("fullName: " + fullName);
 	System.out.println("gender: " + gender);
 	System.out.println("password: " + password);
 	
 	
   }
	catch (SQLException e) {
			e.printStackTrace();
	}
	
	%>
	<div align = center id="empDetail">
	<h1 > Update Data !</h1> 
	<hr>
            <form action="UpdateEmployeeDetails" method="post">
            
                    Full name:
                    <input type="text" id="fullName" name = "fullName" minlength="2" value = <%=fullName %> onchange="validateName()" required><br><br>

                    Gender:
                    <input type="radio" id="gender" name="gender" value="male" checked> Male
                    <input type="radio" id="gender" name="gender" value="female"> Female
                    <input type="radio" id="gender" name="gender" value="other"> Other<br><br>

                    Email Id:
                    <input type="email" id="email" name="email" placeholder="abc@gmail.com" value = <%=email %> onchange="validateEmail()"  readonly >
                    <br><br>

                    Password:
                    <input type="password" id="password" name="password" onchange="validatePassword()" value = <%=password %> required><br><br>

                    Confirm Password:
                    <input type="password" id="confirmPassword" name="confirmPassword" onchange="isPassEqual()" value = <%=password %> required><br><br>

                    Contact Number:
                    <input type="text" id="contact" name="contact"  onchange="validateContact()"  value = <%=contact %> required><br><br>

					Organization Name: 
					<select name="organizationName">
 						 <option value="Oracle">Oracle</option>
  						 <option value="Github">Github</option>
  						 <option value="Metacube">Metacube</option>
  						 <option value="Coursera">Coursera</option>
					</select>

                    <input type="submit"/>
                    <input type="reset">
            </form>
</div>
	
</body>
</html>