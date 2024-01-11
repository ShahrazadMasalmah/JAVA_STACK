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
		<title>New Student</title>
	</head>
	<body>
		<div class="w-50 mx-auto pt-3">
			<h1 class="text-center">New Student</h1>
			<p><a href="/dorms">Dashboard</a></p>
			<form:form class="border p-2" action="/create/student" method="post" modelAttribute="student">
				<div class="mb-3">
					<form:label path="studentName" class="form-label">Name:</form:label>
					<form:errors class="text-danger" path="studentName"></form:errors>
					<form:input path="studentName" class="form-control"/>
				</div>
				<div class="mb-3">
					<form:label path="dorm" class="form-label">Select Dorm:</form:label>
					<form:select path="dorm" class="form-control">
						<c:forEach var="oneDorm" items="${dorms}">
							<form:option value="${oneDorm.id}" path="dorm">
								<c:out value="${oneDorm.dormName}" />
							</form:option>
						</c:forEach>
					</form:select>
				</div> 
				<input type="submit" class="btn btn-info w-100 text-white" value="Add" />
			</form:form>
		</div>
	</body>
</html>