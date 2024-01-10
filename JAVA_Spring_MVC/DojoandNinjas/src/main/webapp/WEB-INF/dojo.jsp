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
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> 
	<title>New Dojo</title>
	</head>
	<body>
		<div class="w-50 p-5">
			<h1 class="mb-3">New Dojo</h1>
			<form:form action="/dojo" method="post" modelAttribute="dojo">
				<div class="mb-3">
					<form:label path="name" class="form-label">Name:</form:label>
					<form:errors class="text-danger" path="name" />
					<form:input class="form-control" path="name" />
				</div>
				<input class="btn btn-primary mt-3" type="submit" value="Create" />
			</form:form>
		</div>
	</body>
</html>