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
		<title>Read Share</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="w-75 mx-auto pt-2">
			<h1 id="book-title">Book Club</h1>
			<p>A place for friends to share thoughts about books.</p>
			<div class="d-flex justify-content-between">
				<div class="border p-3 border-primary register-login">
				 	<h3 class="text-center mb-3">Register</h3>
				 	<form:form action="/register" method="post" modelAttribute="newUser">
				 		<div class="mb-3">
				 			<form:label path="userName" class="form-label">Name:</form:label>
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
				 		<input type="submit" value="Submit" class="btn btn-primary w-100" />
				 	</form:form>
				</div>
				<div class="border p-3 border-primary register-login">
					<h3 class="text-center mb-3">Login</h3>
				 	<form:form action="/login" method="post" modelAttribute="newLogin">
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
				 		<input type="submit" value="Submit" class="btn btn-primary w-100" />
				 	</form:form>
				</div>
			</div>
		</div>
	</body>
</html>