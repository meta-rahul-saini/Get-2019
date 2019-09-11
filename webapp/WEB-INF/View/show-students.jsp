<!-- 
     Jsp page to show the student. 
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body class="container">
	<!--  nav bar -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="showStudentForm">add
					Student</a></li>
		</ul>
	</nav>

 <!--  jstl foreach method -->
	<c:forEach var="student" items="${listOfStudents}">
		<div class="card text-center">
			<div class="card-body">
				<h5 class="card-title">${student.firstName} ${student.lastName}</h5>
				<p class="card-text">${student.fatherName}</p>
				<p class="card-text">${student.email}</p>
				<p class="card-text">${student.age} &nbsp;&nbsp;&nbsp; ${student.standards[0]}</p>
	</div>
		</div>
	</c:forEach>

</body>
</html>