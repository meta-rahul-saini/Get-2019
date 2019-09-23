
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Edit User Info</title>

<style>


.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
.profile-container {position: absolute;
					right: 0px;
					top: 60px;
					background-color: white
					}
					
.profile-container img{position: relative;
					right: 0px;
					top: 0px;
					background-color: white;
					width: 150;
					height: 180}
					
.profile-container button{postion:relative;
					top:240px;right:0px}

</style>
</head>
<body>
	<div class="topnav">
		<a class="active" href="/UserHome">Home</a>
		<a href="/CoWorkers">CoWorkers</a>
		<a href="/Friends">Friends</a>
		<a href="/About">About</a>
		<a href="/Logout" style="float:right;">Logout</a>

	</div>
		<div id="empDetail" class="container" align=center>
		<h1>Register Employee</h1>
		<hr>
		<br />
		<br />
		
		<form:form modelAttribute="employee">
			<%--             <form:errors path="*" cssClass="errorblock" element="div" /><br/><br/> --%>
			<div class="form-group row">
				<label for="fullName" class="col-sm-2 col-form-label">Full
					Name</label>
					<div class="col-sm-10">
						<form:input path="fullName" class="form-control" id="fullName" />
						<form:errors path="fullName" cssClass="error"></form:errors>
			`	</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Gender</label>

				<div class="form-check">
					<form:radiobutton path="gender" class="form-check-input"
						value="male" />
					Male
<!-- 				</div> -->
<!-- 				<div class="form-check-inline"> -->
					<form:radiobutton path="gender" class="form-check-input"
						value="female" />
					Female
<!-- 				</div> -->
<!-- 				<div class="form-check-inline"> -->
					<form:radiobutton path="gender" class="form-check-input"
						value="other" />
					Other
					
				</div>
					<form:errors path="gender" cssClass="error"></form:errors>
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
				<div class="col-sm-10">
				<form:select path="organization" id="organization"
					class="form-control">
					<form:options items="${organizationList}" class="form-control"/>
				</form:select>
				</div>
				<form:errors path="organization" cssClass="error"></form:errors>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-primary">Reset</button>
			
			</form:form>
	</div>
</body>
</html>