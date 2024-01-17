<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Project Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container container-sm container-md container-lg container-xl mt-5 text-start">
      <div class="d-flex justify-content-between">
			<h1>Project Details: </h1> 
      		<p><a href="/dashboard">Back to Dashboard</a></p>
		</div>
      <p class="mt-3">Project : <span class="ms-2"><c:out value="${project.title}" /></span></p>
      <p>Description : <span class="ms-2"><c:out value="${project.description}" /></span></p>
	  <p>Due date : <span class="ms-2"><fmt:formatDate type = "date"  value = "${project.dueDate}" /></span></p>
	  <div class="d-flex justify-content-between">
	  	<p><a href="/projects/${project.id}/tasks">See tasks!</a></p>
	  	<c:if test="${userId == project.leader.id}">
            <form action="/projects/${project.id}/delete" method="post">
              <input type="hidden" name="_method" value="delete">
              <button type="submit" class="btn btn-danger">Delete Project</button>
            </form>
      </c:if>
	  </div>
      <hr class="mx-auto my-5">
    </div>
  </body>
</html>