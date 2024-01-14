<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Book Share</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="w-75 mx-auto pt-2">
			<div class="d-flex justify-content-between">
				<h1>Change your Entry</h1>
				<p><a href="/books">back to the shelves</a></p>
			</div>
			<form:form class="w-75" action="/books/${book.id}" method="post" modelAttribute="book">
				<input type="hidden" name="_method" value="put" />
		 		<div class="mb-3">
		 			<form:label path="title" class="form-label">Title:</form:label>
		 			<form:errors path="title"  class="text-danger"/>
		 			<form:input type="text" path="title" class="form-control" />	
		 		</div>
		 		<div class="mb-3">
		 			<form:label path="author" class="form-label">Author:</form:label>
		 			<form:errors path="author"  class="text-danger"/>
		 			<form:input type="text" path="author" class="form-control" />	
		 		</div>
		 		<div class="mb-3">
		 			<form:label path="thoughts" class="form-label">My Thoughts:</form:label>
		 			<form:errors path="thoughts"  class="text-danger"/>
		 			<form:textarea path="thoughts" class="form-control" />	
		 		</div>
		 		<div class="d-flex justify-content-center">
		 			<input type="submit" value="Submit" class="btn btn-primary" />
		 		</div>
			</form:form>
		</div>
	</body>
</html>