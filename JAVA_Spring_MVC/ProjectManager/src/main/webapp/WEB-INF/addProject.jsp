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
    <meta charset="ISO-8859-1" />
    <title>New Project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>

  <body>
    <div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1> Create a Project </h1> 
      		<p><a href="/dashboard">Back to Dashboard</a></p>
		</div>
      
      <form:form action="/projects/new" method="post" modelAttribute="project" class="container w-100 mt-4">
      <p>
        <form:label path="title" class="form-label">Project Title :</form:label>
        <form:errors path="title" class="text-danger" />
        <form:input type="text" path="title" class="form-control" />
      </p>
      <p>
        <form:label path="description" class="form-label"> Project Description :</form:label>
        <form:errors path="description" class="text-danger" />
        <form:textarea type="text" path="description" cols="30" rows="10" class="form-control" />
      </p>

      <p>
        <form:label path="dueDate" class="form-label">Due Date:</form:label>
        <form:errors path="dueDate" class="text-danger" />
        <form:input type="date" path="dueDate" class="form-control" />
        <!-- <input type="date" name="try" class="form-control"/> -->
      </p>

      <input type="submit" value="Submit" class="btn btn-primary" />
      <input type="reset" value="Cancel " class="btn btn-primary" />
    </form:form>

    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>