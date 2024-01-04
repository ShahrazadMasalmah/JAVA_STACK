<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- For any Bootstrap that uses JS -->
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<title>Ninja Gold Game</title>
	</head>
	<body>
		<div class="ninja-gold">
	        <div class="gold">
	            <h3>Your Gold: </h3>
	            <div id="gold_total">
	              	<p class="text-center"><c:out value="${gold}"/></p>
	            </div>
	        </div>
	        <div class="section">
	            <form class="building" action="/process_money" method="post">
	            <h2>Farm</h2>
	            <input type="hidden" name="building" value="farm" />
	            <input class="submit" type="submit" name="find" value="Find Gold!"/>
	          </form>  
	          <form class="building" action="/process_money" method="post">
	            <h2>Cave</h2>
	            <input type="hidden" name="building" value="cave" />
	            <input class="submit" type="submit" name="find" value="Find Gold!"/>
	          </form> 
	          <form class="building" action="/process_money" method="post">
	            <h2>House</h2>
	            <input type="hidden" name="building" value="house" />
	            <input class="submit" type="submit" name="find" value="Find Gold!"/>
	          </form> 
	          <form class="building" action="/process_money" method="post">
	            <h2>Quest</h2>
	            <input type="hidden" name="building" value="quest" />
	            <input class="submit" type="submit" name="find" value="Find Gold!"/>
	          </form>
	           <form class="building" action="/process_money" method="post">
	            <h2>Spa</h2>
	            <input type="hidden" name="building" value="spa" />
	            <input class="submit" type="submit" name="find" value="Find Gold!"/>
	          </form>   
	        </div>
	        <div class="activity">
	            <h3>Activities:</h3>
	            <div class="scroll" name="activity" contenteditable>
		            <c:forEach var="activity" items="${activities}" >
		            	<c:if test="${activity.contains('earned')}">
	                		<p class="greentext"><c:out value="${activity}"/></p>
	                	</c:if>	
	                	<c:if test="${activity.contains('lost')}">
	                		<p class="redtext"><c:out value="${activity}"/></p>
	                	</c:if>
                	</c:forEach>
	            </div>
	        </div>
	        <form class="d-flex justify-content-center" action="/destroy" method="post">
	            <button class="reset" type="submit" name="button" value="reset">Reset</button>
	        </form>  
      </div>
	</body>
</html>