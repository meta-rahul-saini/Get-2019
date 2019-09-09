<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "Dao.*, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

int empId = Integer.parseInt(request.getParameter("friendId"));
Connection con = ConnectionFactory.getConnection();

Statement st = con.createStatement();

String fetchFriendData = "select * from employee where empId = " + empId;
ResultSet rs = st.executeQuery(fetchFriendData);
rs.next();
%>

<h1> Welcome! <%=rs.getString(2)%></h1><br><br>
<p>Gender: <%=rs.getString(3)%> </p><br/>
<p>contact: <%=rs.getString(6)%> </p><br>
<p>organization: <%=rs.getString(7)%> </p><br>

</body>
</html>