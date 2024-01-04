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
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<title>Prison</title>
	</head>
	<body class="pt-5">
		 <h1 class="text-danger text-center">You made it to the prison please pay your debts!</h1>
		 <form class="d-flex justify-content-center" action="/destroy" method="post">
	            <button class="go" type="submit" name="button" value="reset">Go Back</button>
	        </form>
	</body>
</html>