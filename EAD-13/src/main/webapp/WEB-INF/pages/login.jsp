<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>

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

<body align="center">

	<div class="container">
		<h2>Login</h2>
		<form action="/login" method="POST">

			<h4 class="text-danger">${errorMsg}</h4>

			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label"> Email: </label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="username"
						name="username" />
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">
					Password: </label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						name="password" />
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-primary">Reset</button>
		</form>
	</div>
</body>
</html>