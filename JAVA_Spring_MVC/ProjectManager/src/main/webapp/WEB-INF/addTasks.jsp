<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Props Pages</title>
		<title>New Project</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container mt-5">
			<div class="d-flex justify-content-between">
			<h1>Project: <c:out value="${project.title}" /></h1> 
      		<p><a href="/dashboard">Back to Dashboard</a></p>
		</div>
		</div>
		<p class="container">Project Lead: <c:out value="${project.leader.firstName}" /></p>
		<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task" class="container w-100 mt-4">
	      <p>
	        <form:label path="taskTitle" class="form-label">Add a task ticket for this team:</form:label>
	        <form:errors path="taskTitle" class="text-danger" />
	        <form:input type="text" path="taskTitle" class="form-control" />
	      </p>
	      <input type="submit" value="Submit" class="btn btn-primary" />
      </form:form>
      <div class="container mt-5">
      	<c:forEach var="task" items="${project.projectTasks}">
      		<p><strong>- Added by <c:out value="${task.user.firstName}" /> at 
      			<fmt:formatDate type = "both" pattern = "hh:mma MMM d"  value = "${task.createdAt}" />:
      		</strong></p>
      		<p class="ms-2"><c:out value="${task.taskTitle}" /></p>
      	</c:forEach>
      </div>
	</body>
</html>