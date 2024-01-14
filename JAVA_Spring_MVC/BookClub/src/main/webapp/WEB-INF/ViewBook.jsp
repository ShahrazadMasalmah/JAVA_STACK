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
			<div class="d-flex justify-content-between">
				<h1><c:out value="${book.title}" /></h1>
				<p><a href="/books">back to the shelves</a></p>
			</div>
			<div class="w-75 mt-5">
				<c:if test="${book.user.id == user.id}">
					<h4><span class="text-danger"><c:out value="${book.user.userName}" /></span> read 
					<span id="book-title"><c:out value="${book.title}" /></span> by <span class="text-success"><c:out value="${book.author}" /></span></h4>
					<p>Here are <c:out value="${book.user.userName}" /> thoughts:</p>
					<div class="border-top border-bottom border-primary py-3 ms-3">
						<p class="mx-4"><c:out value="${book.thoughts}" /></p>
					</div>
					<div class="d-flex justify-content-center mt-5">
						<a class="me-2" href="/books/${book.id}/edit"><button class="btn btn-success">edit</button></a>
						<a href="/books/${book.id}/delete"><button class="btn btn-danger">delete</button></a>
					</div>
				</c:if>
				<c:if test="${book.user.id != user.id}">
					<h4>Author: <span id="book-title"><c:out value="${book.author}" /></span></h4>
					<h4>Posted by: <span class="text-danger"><c:out value="${book.user.userName}" /></span></h4>
					<p><c:out value="${book.user.userName}" /> thoughts:</p>
					<div class="border-top border-bottom border-primary py-3 ms-3">
						<p class="mx-4"><c:out value="${book.thoughts}" /></p>
					</div>
				</c:if>
			</div>
		</div>
	</body>
</html>