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
				<div>
					<h1>Welcome, <c:out value="${user.userName}" /></h1>
					<p>Books from everyones shelves:</p>
				</div>
				<div>
					<p id="logout" style="margin-left: 72%;"><a href="/logout">Logout</a></p>
					<p><a href="/books/new">+ Add a book to my shelf!</a></p>
				</div>
			</div>
			<table class="table table-hover text-center table-bordered border-primary">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Title</th>
			      <th scope="col">Author Name</th>
			      <th scope="col">Posted By</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="book" items="${books}">
				  	<tr>
				      <th scope="row"><c:out value="${book.id}" /></th>
				      <td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
				      <td><c:out value="${book.author}" /></td>
				      <td><c:out value="${book.user.userName}" /></td>
				    </tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
	</body>
</html>