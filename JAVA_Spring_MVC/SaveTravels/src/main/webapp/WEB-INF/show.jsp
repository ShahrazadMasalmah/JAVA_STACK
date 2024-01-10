<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
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
		<title>Show Expense</title>
	</head>
	<body>
		<div class="w-50 mx-auto pt-3">
			<div class="d-flex justify-content-between mb-3">
				<h2 class="text-primary">Expense Details</h2>
				<p><a href="/expenses">Go back</a></p>
			</div>
			<div>
				<p><strong>Expense Name:</strong> <span class="ms-3"><c:out value="${expense.expenseName}" /></span></p>
				<p><strong>Expense Description:</strong> <span class="ms-3"><c:out value="${expense.description}" /></span></p>
				<p><strong>Vendor:</strong> <span class="ms-3"><c:out value="${expense.vendor}" /></span></p>
				<p><strong>Amount Spent:</strong> <span class="ms-3">$<c:out value="${expense.amount}" /></span></p>
			</div>
		</div>
	</body>
</html>