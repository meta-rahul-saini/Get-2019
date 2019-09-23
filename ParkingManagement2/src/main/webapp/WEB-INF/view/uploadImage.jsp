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
<title>Upload Image</title>


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
<BR><BR>
<form:form modelAttribute="uploadImage" method = "POST" enctype="multipart/form-data">
   <table>
       <tr>
           <td><form:label path="file">Select a file to upload</form:label></td>
           <td><input type="file" name="file" value="browse" class="btn" /></td>
       </tr>
       <tr>
           <td><input type="submit"  class="btn btn-primary" value="Submit" /></td>
       </tr>
   </table>
</form:form>
</body>
</html>