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
		 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<title>New Dorm</title>
	</head>
	<body>
		<div class="w-50 mx-auto pt-3">
			<h1 class="text-center">New Dorm</h1>
			<p><a href="/dorms">Dashboard</a></p>
			<form:form class="border p-2" action="/create/dorm" method="post" modelAttribute="dorm">
				<div class="mb-3">
					<form:label path="dormName" class="form-label">Name:</form:label>
					<form:errors class="text-danger" path="dormName"></form:errors>
					<form:input path="dormName" class="form-control"/>
				</div>
				<input type="submit" class="btn btn-info mt-3 w-100 text-white" value="Add" />
			</form:form>
		</div>
	</body>
</html>