<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- For any Bootstrap that uses JS -->
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<title>Reading Books</title>
	</head>
	<body class="px-5 pt-4">
		<h1>All Books</h1>
		<table class="table table-hover pt-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th># Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.getId()}"></c:out></td>
					<td><a href="/books/${book.getId()}"><c:out value="${book.getTitle()}"></c:out></a></td>
					<td><c:out value="${book.getLanguage()}"></c:out></td>
					<td><c:out value="${book.getNumberOfPages()}"></c:out></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
</html>