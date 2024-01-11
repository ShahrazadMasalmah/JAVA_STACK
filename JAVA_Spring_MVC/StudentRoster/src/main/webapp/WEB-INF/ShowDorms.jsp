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
		<title>Dorms</title>
	</head>
	<body>
		<div class="w-50 mx-auto pt-3">
			<h1 class="text-center">Dorms</h1>
			<p><a href="/dorms/new">Add a new dorm</a></p>
			<p><a href="/students/new">Add a new student</a></p>
			<table class="table table-hover text-center">
				<thead>
					<tr>
						<th>Dorm</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneDorm" items="${dorms}">
						<tr>
							<td><c:out value="${oneDorm.dormName}" /></td>
							<td><a href="/dorms/${oneDorm.id}">See Students</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>