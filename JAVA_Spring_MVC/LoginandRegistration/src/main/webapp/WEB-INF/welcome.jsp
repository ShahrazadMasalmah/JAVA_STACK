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
		<title>Dashboard</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="p-3">
			<h1>Welcome, 
			 <c:choose>
			 	<c:when test="${!user.equals(null)}"><c:out value="${user.userName}" />!</c:when>
			 	<c:otherwise>Guest!</c:otherwise>
			 </c:choose>
			</h1>
			<p>This is your dashboard. Nothing to see here yet.</p>
			<p><a href="/logout">Logout</a></p>
		</div>
	</body>
</html>