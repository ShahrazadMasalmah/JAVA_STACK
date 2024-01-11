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
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<title>${dorm.dormName}</title>
	</head>
	<body>
		<div class="w-50 mx-auto pt-3">
			<h1 class="text-center"><c:out value="${dorm.dormName}" /> Students</h1>
			<p><a href="/dorms">Dashboard</a></p>
			<form class="border p-2" action="/add/student/${dorm.id}" method="GET">
				<div class="mb-2">
					<label for="studentId" class="form-label">Students:</label>
					<select name="studentId" class="form-control" id="studentId">
						<c:forEach var="oneStudent" items="${allStudents}">
							<option value="${oneStudent.id}">
								<c:out value="${oneStudent.studentName}" /> (<c:out value="${oneStudent.dorm.dormName}" />)
							</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" class="btn btn-info mt-3 w-100 text-white" value="Add" />
			</form>
			<table class="table table-hover mt-5 text-center">
				<thead>
					<tr>
						<th>Student</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneStudent" items="${dorm.students}">
						<tr>
							<td><c:out value="${oneStudent.studentName}" /></td>
							<td><a href="/students/remove/${oneStudent.id}">Remove</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>