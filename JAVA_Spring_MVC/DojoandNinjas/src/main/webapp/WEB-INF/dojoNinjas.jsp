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
		<title>Dojo Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> 
	</head>
	<body>
		<div class="w-50 p-5">
			<h1 class="mb-3"><c:out value="${dojo.name}" /> Ninjas</h1>
			<table class="table table-hover">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach var="oneNinja" items="${dojo.ninjas}">
							<tr>
							
								<td><c:out value="${oneNinja.firstName}" /></td>
								<td><c:out value="${oneNinja.lastName}" /></td>
								<td><c:out value="${oneNinja.age}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		
	</body>
</html>