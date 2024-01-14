<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Category</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="w-75 mx-auto pt-5">
			<h1 class="text-center">New Category</h1>
			<p><a href="/">Home</a></p>
		 	<form:form action="/categories/new" method="post" modelAttribute="category" class="border p-3 border-primary">
		 		<div class="mb-3">
		 			<form:label path="name" class="form-label">Name:</form:label>
		 			<form:errors path="name"  class="text-danger"/>
		 			<form:input type="text" path="name" class="form-control" />	
		 		</div>
		 		<input type="submit" value="Submit" class="btn btn-primary w-100" />
		 	</form:form>
		</div>
	</body>
</html>