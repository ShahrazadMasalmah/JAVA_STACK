<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<title>Fruit Store</title>
	</head>
	<body>
		<div class="store">
			<h1 id="name">Fruit Store</h1>
			<table id="items">
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="item" items="${fruits}">
				    <tr>
				    	<td><c:out value="${item.getName()}"></c:out></td>
						<td><c:out value="${item.getPrice()}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>