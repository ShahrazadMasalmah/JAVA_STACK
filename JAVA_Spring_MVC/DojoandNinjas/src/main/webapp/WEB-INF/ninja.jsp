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
		<title>New Ninja</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> 
	</head>
	<body>
		<div class="w-50 p-5">
			<h1 class="mb-3">New Ninja</h1>
			<form:form action="/ninja" method="post" modelAttribute="ninja">
				<div class="mb-3">
					<form:label path="dojo" class="form-label">Dojo:</form:label>
					 <form:select path="dojo" class="form-control">
				        <c:forEach var="oneDojo" items="${dojos}">
				            <!--- Each option VALUE is the id of the person --->
					            <form:option value="${oneDojo.id}" path="dojo">
				            <!--- This is what shows to the user as the option --->
				                <c:out value="${oneDojo.name}"/>
				            </form:option>
				        </c:forEach>
	    			</form:select>
				</div>
				
				<div class="mb-3">
					<form:label path="firstName" class="form-label">First Name:</form:label>
					<form:errors class="text-danger" path="firstName" />
					<form:input class="form-control" path="firstName" />
				</div>
				<div class="mb-3">
					<form:label path="lastName" class="form-label">Last Name:</form:label>
					<form:errors class="text-danger" path="lastName" />
					<form:input class="form-control" path="lastName" />
				</div>
				<div class="mb-3">
					<form:label path="age" class="form-label">Age:</form:label>
					<form:errors class="text-danger" path="age" />
					<form:input type="number" class="form-control" path="age" />
				</div>
				<input class="btn btn-primary mt-3" type="submit" value="Create" />
			</form:form>
		</div>
	</body>
</html>