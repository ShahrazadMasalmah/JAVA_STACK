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
		<title>Login and Registration</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="w-75 mx-auto pt-2">
			<h1>Welcome!</h1>
			<p>Join our growing community.</p>
			<div class="border p-3 border-primary">
			 	<h3 class="text-center mb-3">Register</h3>
			 	<form:form action="/register" method="post" modelAttribute="newUser">
			 		<div class="mb-3">
			 			<form:label path="userName" class="form-label">Username:</form:label>
			 			<form:errors path="userName"  class="text-danger"/>
			 			<form:input type="text" path="userName" class="form-control" />	
			 		</div>
			 		<div class="mb-3">
			 			<form:label path="email" class="form-label">Email:</form:label>
			 			<form:errors path="email"  class="text-danger"/>
			 			<form:input type="email" path="email" class="form-control" />	
			 		</div>
			 		<div class="mb-3">
			 			<form:label path="password" class="form-label">Password:</form:label>
			 			<form:errors path="password"  class="text-danger"/>
			 			<form:input type="password" path="password" class="form-control" />	
			 		</div>
			 		<div class="mb-3">
			 			<form:label path="confirmPassword" class="form-label">Confirm PW:</form:label>
			 			<form:errors path="confirmPassword"  class="text-danger"/>
			 			<form:input type="password" path="confirmPassword" class="form-control" />	
			 		</div>
			 		<input type="submit" value="Submit" class="btn btn-success w-100" />
			 	</form:form>
			</div>
			<div class="border p-3 mt-5 border-primary">
				<h3 class="text-center mb-3">Login</h3>
			 	<form:form action="/login" method="post" modelAttribute="loginUser">
			 		<div class="mb-3">
			 			<form:label path="email" class="form-label">Email:</form:label>
			 			<form:errors path="email"  class="text-danger"/>
			 			<form:input type="email" path="email" class="form-control" />	
			 		</div>
			 		<div class="mb-3">
			 			<form:label path="password" class="form-label">Password:</form:label>
			 			<form:errors path="password"  class="text-danger"/>
			 			<form:input type="password" path="password" class="form-control" />	
			 		</div>
			 		<input type="submit" value="Submit" class="btn btn-success w-100" />
			 	</form:form>
			</div>
		</div>
	</body>
</html>