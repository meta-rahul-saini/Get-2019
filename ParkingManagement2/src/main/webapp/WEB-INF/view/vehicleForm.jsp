
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Vehicle Form</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="about">About
				</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Log
						out</a></li>
			</ul>
		</div>
	</nav>
	<hr>
	<div id="vehicleForm" align="center" class="container"
		style="display: block">
		<h1>Add Vehicle</h1>
		<hr />
		<br /> <br />
		<form:form action="submitVehicleForm" modelAttribute="vehicle">

			<div class="form-group row">
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h3 class="display">Employee Id: ${empId}</h3>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="vehicleName" class="col-sm-2 col-form-label">Vehicle
					Name </label>
				<div class="col-sm-10">
					<form:input path="vehicleName" class="form-control"
						id="vehicleName" />
					<form:errors path="vehicleName" cssClass="error"></form:errors>
					`
				</div>
			</div>

			<div class="form-group row">
				<label for="vehicleType" class="col-sm-2 col-form-label">Vehicle
					Type</label>
				<form:select path="vehicleType" id="vehicleType"
					class=" form-control col-sm-10">
					<form:option value="cycle"> cycle</form:option>
					<form:option value="twoWheeler"> two wheeler</form:option>
					<form:option value="fourWheeler">four wheeler </form:option>
				</form:select>
				<form:errors path="vehicleType" cssClass="error"></form:errors>
			</div>

			<div class="form-group row">
				<label for="vehicleNumber" class="col-sm-2 col-form-label">Vehicle
					Number </label>
				<div class="col-sm-10">
					<form:input path="vehicleNumber" class="form-control"
						id="vehicleNumber" />
					<form:errors path="vehicleNumber" cssClass="error"></form:errors>
					`
				</div>
			</div>

			<div class="form-group row">
				<label for="vehicleNumber" class="col-sm-2 col-form-label">Vehicle
					Identification </label>
				<div class="col-sm-10">
					<form:textarea path="identification" rows="5" cols="30" />
				</div>
			</div>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form:form>
	</div>
	<br />
	<br />
</body>
</html>