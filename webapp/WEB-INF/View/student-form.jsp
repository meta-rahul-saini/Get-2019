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
	color: red;
}
</style>


</head>

<body>

	<div class="container">

		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="showStudentForm">add
						Student</a></li>
			</ul>
		</nav>

		<h1>Add Student Details</h1>

		<hr>

		<!-- 	form -->
		<form:form action="ProcessStudentForm" modelAttribute="student">
			<div class="form-group">

				<p>required fields are indicated by *</p>

				<div class="form-group">
					<label for="firstName">First name*:</label>
					<form:input path="firstName" name="firstName" id="firstName"
						class="form-control" placeholder="Enter first name" />
					<form:errors path="firstName" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="lastName">Last name:</label>
					<form:input path="lastName" name="lastName" id="lastName"
						class="form-control" placeholder="Enter last name" />
					<form:errors path="lastName" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="fatherName">father name*:</label>
					<form:input path="fatherName" name="fatherName" id="fatherName"
						class="form-control" placeholder="Enter father name" />
					<form:errors path="fatherName" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="email">Email address:</label>
					<form:input path="email" name="email" id="email"
						class="form-control" placeholder="Enter email" />
					<form:errors path="email" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="age">Age:</label>
					<form:input path="age" name="age" id="age" class="form-control"
						placeholder="Enter age" />
					<form:errors path="age" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="standards">Standard:</label>
					<form:select path="standards" class="form-control">
						<form:options items="${student.standards}" />
					</form:select>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>

	</div>
</body>
</html>

