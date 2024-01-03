<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Current Visit Count</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<h2>You have visited <a class="linkColor" href="/">http://your_server </a><c:out value="${count}"></c:out> times.</h2>
		<h2><a class="linkColor" href="/">Test another visit?</a></h2>
		<button class="reset"><a id="link" href="/reset">Reset</a></button>
	</body>
</html>