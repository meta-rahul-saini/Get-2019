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
<body >
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	
		<a class="navbar-brand" href="home">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/about">About
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Log out</a>
				</li>
			</ul>
		</div>
	</nav>


	<div class="container" align=center>
		<h1>Coworkers List</h1>
		<hr>

		<!--  jstl foreach method -->
		<c:forEach var="coworker" items="${coworkersList}">
			<div class="card text-center">
				<div class="card-body">
					<h5 class="card-title">${coworker.fullName}</h5>
					<p class="card-text">${coworker.email}</p>
					<p class="card-text">${coworker.empId}&nbsp;&nbsp;&nbsp;
						${coworker.contactNumber}</p>
				</div>
			</div>
		</c:forEach>
</body>
</html>