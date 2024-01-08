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
	<body class="ps-5 pt-4">
		<h1><c:out value="${thisBook.getTitle()}"></c:out></h1>
		<h4 class="pt-3">Description: <c:out value="${thisBook.getDescription()}"></c:out></h4>
		<h4>Language: <c:out value="${thisBook.getLanguage()}"></c:out></h4>
		<h4>Number Of Pages: <c:out value="${thisBook.getNumberOfPages()}"></c:out></h4>
	</body>
</html>