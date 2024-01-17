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
       <title>Project Manager Dashboard</title>
       <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
     </head>
     <body>
       <div class="container mt-5">
         <div class="d-flex justify-content-between">
           <hgroup>
             <h1>Welcome, ${thisUser.firstName}!</h1>
           </hgroup>
           <div>
             <a href="/logout" class="btn btn-link"> Logout</a> <br>
             <a href="/projects/new" class="btn btn-link">+ new project</a>
           </div>
         </div>
         <h3 class="w-75 mx-auto mt-3">All Projects </h3>
         <table class="table table-border table-hover border-primary w-75 mx-auto mt-2">
           <thead>
             <tr class="text-center">
               <th scope="col">ID</th>
               <th scope="col">Project</th>
               <th scope="col">Team Lead </th>
               <th scope="col"> Due Date</th>
               <th scope="col"> Actions </th>
             </tr>
           </thead>
           <tbody>
             <c:forEach var="project" items="${notProjects}">
               <tr>
                 <td class="text-center">
                   <c:out value="${project[0]}" />
                 </td>
                 <td class="text-center">
                   <a href="/projects/${project[0]}">${project[1]}</a>
                 </td>
                 <td class="text-center">
                   <c:out value="${project[2]}" />
                 </td>
                 <td class="text-center">
                   <fmt:formatDate type = "date"  value = "${project[3]}" />
                 </td>
                 <td>
                   <a href="/projects/${project[0]}/join">Join team</a>
                 </td>
               </tr>
             </c:forEach>
           </tbody>
         </table>
         <h3 class="w-75 mx-auto mt-5">Your Projects </h3>
         <table class="table table-border table-hover border-primary w-75 mx-auto mt-2">
           <thead>
             <tr class="text-center">
               <th scope="col">ID</th>
               <th scope="col">Project</th>
               <th scope="col">Lead </th>
               <th scope="col"> Due Date</th>
               <th scope="col"> Actions </th>
             </tr>
           </thead>
           <tbody>
             <tr>
               <c:forEach var="column" items="${leaderProjects}">
             <tr>
               <td class="text-center">
                 <c:out value="${column[0]}" />
               </td>
               <td class="text-center">
                 <a href="/projects/${column[0]}">${column[1]}</a>
               </td>
               <td class="text-center">
                 <c:out value="${column[2]}" />
               </td>
               <td class="text-center">
                <fmt:formatDate type = "date"  value = "${column[3]}" />
               </td>
               <c:if test="${thisUser.id eq column[4]}">
                 <td class="d-flex">
                   <a href="/projects/${column[0]}/edit" class="btn btn-link">Edit</a>
                   <!--form action="/projects/${column[0]}/delete" method="post">
                     <input type="hidden" name="_method" value="delete">
                     <button type="submit" class="btn btn-link text-danger">Delete</button>
                   </form-->
                 </td>
               </c:if>
               <td>
                 <c:if test="${thisUser.id != column[4]}">
                   <a href="/projects/${column[0]}/leave">Leave team</a>
                 </c:if>
               </td>
             </tr>
             </c:forEach>
             </tr>

           </tbody>
         </table>
       </div>
       <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
     </body>
</html>