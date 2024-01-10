<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
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
		<title>Edit Expense</title>
	</head>
	<body>
		<div class="w-50 mx-auto pt-3">
			<div class="d-flex justify-content-between">
				<h2 class="text-success">Edit Expense</h2>
				<p><a href="/expenses">Go back</a></p>
			</div>
			<form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
				<div class="mb-3">
					<form:label path="expenseName" class="form-label">Expense Name:</form:label>
					<form:errors class="text-danger" path="expenseName" />
					<form:input class="form-control" path="expenseName" />
				</div>
				<div class="mb-3">
					<form:label path="vendor" class="form-label">Vendor:</form:label>
					<form:errors class="text-danger" path="vendor" />
					<form:input class="form-control" path="vendor" />
				</div>
				<div class="mb-3">
					<form:label path="amount" class="form-label">Amount:</form:label>
					<form:errors class="text-danger" path="amount" />
					<form:input class="form-control" path="amount" />
				</div>
				<div>
					<form:label path="description" class="form-label">Description:</form:label>
					<form:errors class="text-danger" path="description" />
					<form:textarea class="form-control" path="description" />
				</div>
				<input class="btn btn-primary mt-3" type="submit" value="Submit" />
			</form:form>
		</div>
	</body>
</html>