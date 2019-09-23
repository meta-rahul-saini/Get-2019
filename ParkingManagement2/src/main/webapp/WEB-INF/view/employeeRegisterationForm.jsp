
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<title>Employee Registration</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link href="style.css" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>

.error {
	font: 11pt verdana;
	font-weight: 70;
	color: red;
}
</style>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Contact</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">About
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="login">Login</a>
			</li>
		</ul>
	</div>
	</nav>


	<div id="empDetail" class="container" align=center>
		<h1>Register Employee</h1>
		<hr>
		<br /> <br />

		<form:form modelAttribute="employee" action="registerEmployee">
			<%--             <form:errors path="*" cssClass="errorblock" element="div" /><br/><br/> --%>
			<div class="form-group row">
				<label for="fullName" class="col-sm-2 col-form-label">Full
					Name</label>
				<div class="col-sm-10">
					<form:input path="fullName" class="form-control" id="fullName" />
					<form:errors path="fullName" cssClass="error"></form:errors>
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Gender</label>

				<%--                     <form:radiobuttons path="gender" class="form-check-input" items="${genderList}"/> --%>

				<%--                     <form:errors path="gender"  cssClass="CssStyle1" /><br/><br/> --%>
				<div class="form-check-inline">
					<form:radiobutton path="gender" class="form-check-input"
						value="male" />
					Male
				</div>
				<div class="form-check-inline">
					<form:radiobutton path="gender" class="form-check-input"
						value="female" />
					Female
				</div>
				<div class="form-check-inline">
					<form:radiobutton path="gender" class="form-check-input"
						value="other" />
					Other

				</div>
				<form:errors path="gender" cssClass="error"></form:errors>
			</div>


			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email"
						placeholder="example@gmail.com" />
					<form:errors path="email" cssClass="error"></form:errors>
				</div>
			</div>


			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<form:password path="password" class="form-control" id="password" />
					<form:errors path="password" cssClass="error"></form:errors>
				</div>
			</div>

			<div class="form-group row">
				<label for="confirmPassowrd" class="col-sm-2 col-form-label">Confirm
					Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="confirmPassowrd"
						onchange="isPassEqual()" />
				</div>
			</div>

			<div class="form-group row">
				<label for="contactNumber" class="col-sm-2 col-form-label">Contact
					Number</label>
				<div class="col-sm-10">
					<form:input path="contactNumber" class="form-control"
						id="contactNumber" />
					<form:errors path="contactNumber" cssClass="error"></form:errors>
				</div>
			</div>


			<div class="form-group row">
				<label for="organization" class="col-sm-2 col-form-label">Organization</label>
				<form:select path="organization" id="organization"
					class=" form-control col-sm-10">
					<form:options items="${organizationList}" />
				</form:select>
				<form:errors path="organization" cssClass="error"></form:errors>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-primary">Reset</button>
			<br />
			<br />
                    
                    Already registered?<br />
			<a href="login">Login</a>
		</form:form>
	</div>
</body>
</html>