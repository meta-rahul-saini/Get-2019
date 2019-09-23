<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		class="navbar-brand" href="#">Login</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/">Register Employee
			</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">


		<form:form modelAttribute="login" action="processCredentials"
			method="post">
			
			<div class="col-sm-12 form-group row">
				<form:errors path="credentials" class="col-sm-6 alert alert-danger"></form:errors>
			</div>
			
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label"> Email: </label>
				<div class="col-sm-6">
					<form:input path="email" class="form-control" id="email"
						name="email" />
					<form:errors path="email"></form:errors>
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">
					Password: </label>
				<div class="col-sm-6">
					<form:input path="password" class="form-control" id="password"
						name="password" />
					<form:errors path="password" cssClass="error"></form:errors>

				</div>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-primary">Reset</button>
		</form:form>
	</div>
</body>
</html>