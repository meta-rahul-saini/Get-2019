<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<title>Home page</title>
</head>
<body>
	
	

 
    <!-- 	 nav bar -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/home">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="addStudent">add
					Student</a></li>
					
			<li class="nav-item"><a class="nav-link" href="showAllStudent">show Student</a></li>
			
			<li class="nav-item"><a class="nav-link" href="searchStudent">Search Student</a></li>
		</ul>
	</nav>
<br><br>
<div class = "container" >
	<div class="jumbotron text-center bg-warning text-white">
		<h1>${message }</h1>
  	  </div>
</div>
 
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>