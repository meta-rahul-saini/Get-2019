<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Congratulation</title>

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

		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item "><a class="nav-link" href="/">Home</a>
				</li>
				<li class="nav-item active" ><a class="nav-link" href="studentForm">add
						Student</a></li>
						
				<li class="nav-item"><a class="nav-link" href="showAllStudent">show All Student</a></li>
			</ul>
		</nav>
<br><br>
<div  class="alert alert-success container">Conratulations ${student.firstName}!. Form Submitted Successfully</div>
</body>
</html>