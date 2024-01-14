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
		<title>Home</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="w-75 mx-auto pt-5">
			<h1 class="text-center">Home Page</h1>
			<p><a href="/products/new">New Product</a></p>
			<p><a href="/categories/new">New Category</a></p>
			<table class="table table-hover table-bordered border-primary mt-3">
			  <thead>
			    <tr>
			      <th class="text-center" scope="col">Products</th>
			      <th class="text-center" scope="col">Categories</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<tr>
			  		<td>
					  	<c:forEach var="product" items="${products}">
					  		
					  		 <ul>
						 		<li><a href="/products/${product.id}"><c:out value="${product.name}" /></a></li>    	
						     </ul>
					  	</c:forEach>
			  		</td>
			  		<td>
					  	<c:forEach var="category" items="${categories}">
					  		
					  		 <ul>
						 		<li><a href="/categories/${category.id}"><c:out value="${category.name}" /></a></li>    	
						     </ul>
					  	</c:forEach>
			  		</td>
			  	</tr>
			  </tbody>
			</table>
		</div>
	</body>
</html>