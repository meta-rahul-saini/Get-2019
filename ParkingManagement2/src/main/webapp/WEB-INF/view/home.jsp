
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<title>Employee Registration</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
</style>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="home">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="about">About
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="addVehicle">Add Vehicle </a></li>
			<li class="nav-item"><a class="nav-link" href="friends">Friends</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/coworkers">Coworkers</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="logout">Log
					out</a></li>
		</ul>
	</div>
	</nav>
<br><br>
	 <!--  jstl foreach method -->
	<div class="container">
	<c:forEach var="vehicle" items="${vehicleList}">
		<div class="card text-center">
			<div class="card-body">
				<h5 class="card-title">${vehicle.vehicleName}</h5>
				<p class="card-text">${vehicle.vehicleType}</p>
				<p class="card-text">${vehicle.vehicleNumber} &nbsp;&nbsp;&nbsp; ${vehicle.vehicleId}</p>
				<p class="card-text">${vehicle.identification}</p>
				
	
	</div>
		</div>
	</c:forEach></div>

</body>

<script>
	
</script>
</html>