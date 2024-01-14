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
		<title>Product Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="w-75 mx-auto pt-5">
			<h1 class="text-center"><c:out value="${product.name}" /></h1>
			<p><a href="/">Home</a></p>
			<div class="border-top border-bottom border-primary py-2 px-4 w-75">
				<p>Categories:</p>
				<c:forEach var="category" items="${product.categories}">
					<p>- <c:out value="${category.name}" /></p>
				</c:forEach>
			</div>
			<form action="/products/${product.id}" method="post" class="mt-3 w-75">
				<div class="mb-3">
        			<label for="category" class="form-label">Add Category:</label>
        			<select name="categoryId" id="category" class="form-control">
          				<c:forEach items="${categories}" var="category">
            				<option value="${category.id}"><c:out value="${category.name}" /></option>
				        </c:forEach>  
				    </select>
				</div>
				<div class="d-flex justify-content-center">
					<input type="submit" class="btn btn-primary w-25" value="Add">
				</div>
			</form>
		</div>
	</body>
</html>