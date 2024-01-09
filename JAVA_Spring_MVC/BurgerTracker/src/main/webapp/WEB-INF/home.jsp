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
		<title>Burger Tracker</title>
	</head>
	<body>
		<div class="w-50 mx-auto">
			<h1 class="text-primary">Burger Tracker</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Burger Name</th>
							<th>Restaurant Name</th>
							<th>Rating (out of 5)</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach var="burger" items="${burgers}">
							<tr>
							
								<td>${burger.burgerName}</td>
								<td>${burger.restaurantName}</td>
								<td>${burger.rating}</td>
								<td><a href="/burgers/edit/${burger.id}">edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			<h2 class="text-primary mt-5">Add a Burger</h2>
			<form:form action="/burger" method="post" modelAttribute="burger">
				<div class="mb-3">
					<form:label path="burgerName" class="form-label">Burger Name</form:label>
					<form:errors class="text-danger" path="burgerName" />
					<form:input class="form-control" path="burgerName" />
				</div>
				<div class="mb-3">
					<form:label path="restaurantName" class="form-label">Restaurant Name</form:label>
					<form:errors class="text-danger" path="restaurantName" />
					<form:input class="form-control" path="restaurantName" />
				</div>
				<div class="mb-3">
					<form:label path="rating" class="form-label">Rating</form:label>
					<form:errors class="text-danger" path="rating" />
					<form:select class="form-control" path="rating" >
						<% for(int i=0; i < 6; i++){ %>
							<option><%= i %></option>
						<% } %>
					</form:select>
				</div>
				<div>
					<form:label path="notes" class="form-label">Notes</form:label>
					<form:errors class="text-danger" path="notes" />
					<form:textarea class="form-control" path="notes" />
				</div>
				<input class="btn btn-primary mt-3" type="submit" value="Submit" />
			</form:form>
		</div>
	</body>
</html>