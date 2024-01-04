<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Show</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href = "/css/style.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</head>
	<body>
		<h1 class="text-center">Here's your Omikuji!! </h1>
		<div class="bg-primary p-3">
		<h4 class="text-white">In <c:out value="${number}"/> years , you will live in <c:out value="${city}"/> with
			 <c:out value="${name}"/> as your roommate, <c:out value="${hobby}"/> for a living.
			  the next time you see a <c:out value="${thing}"/>, you will have good luck. 
			  Also, <c:out value="${message}"/></h4>
		</div>
		<div class="d-flex justify-content-center mt-4">
			<a href="/omikuji">Go back !!</a>
		</div>
	</body>
</html>