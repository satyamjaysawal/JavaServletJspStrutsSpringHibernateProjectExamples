<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>



<!DOCTYPE html>
<html>
<head>
<title>JSP JSTL Example</title>
</head>
<body>
	<h1>JSP JSTL Example</h1>

	<!-- JSP Expression -->
	<p> Current Date and Time: <%=new java.util.Date()%></p>


	<!-- JSP Scriptlet -->
	<% String message = "Hello from JSP Scriptlet!";%>
	<p><%=message%></p>

	<!-- JSP Declaration -->
	<%!int number1 = 10;
	int number2 = 20;
	int sum = number1 + number2;%>
	<p>Sum of <%=number1%> and <%=number2%> is <%=sum%></p>



	<!-- Core Tags -->
	<h3>Welcome to javaTpoint</h3>
	
	<c:set var="income" scope="session" value="${4000*4}"/>  
	<c:if test="${income > 8000}">  
   		<p>My income is: <c:out value="${income}"/><p>  
	</c:if>  
		<c:choose>  
	    	<c:when test="${income <= 1000}">Income is not good.</c:when>  
	    	<c:when test="${income > 10000}">Income is very good.</c:when>  
	   		<c:otherwise>Income is undetermined...</c:otherwise>  
		</c:choose>  


	<!-- Looping with Core Tags -->
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>Iteration ${i}</p>
	</c:forEach>


	<!-- Formatting Tags -->
	<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd HH:mm:ss" var="now" /> 
	<p>Formatted Date: ${now}</p>


	<!-- Using Formatting Tags to format numbers -->
	<fmt:formatNumber value="12345.6789" type="currency" currencyCode="USD" var="formattedNumber" />
	<p>Formatted Number: ${formattedNumber}</p>


	<!-- catchtheException  -->
	<c:catch var="catchtheException">
    	<% String str = null;
        int length = str.length();%>
	</c:catch>
	    <c:if test="${not empty catchtheException}">
	        <p>A NullPointerException occurred: ${catchtheException}</p>
	    </c:if>


	<!-- JSP Exception Handling -->
	<% try { int result = 10 / 0;                                // Throws ArithmeticException
	} catch (Exception e) { pageContext.setAttribute("errorMessage", "An error occurred: " + e.getMessage());}%>
	<p>${errorMessage}</p>




	<!-- Url Tracking  -->
	<c:url value="/index.jsp" var="completeURL">
		<c:param name="trackingId" value="786" />
		<c:param name="user" value="Nakul" />
	</c:url> 
	<h3>Complete URL</h3> ${completeURL}  <br><hr>
	<a href="index.jsp">Back to Registration</a>
	




	<!--  Redirect Example -->
	<form action="#" method="post">
		<input type="hidden" name="submitClicked" value="true" /><br>
	 	<input type="submit" value="Click to redirect javatpoint " />
	</form>
	<c:choose>
		<c:when test="${param.submitClicked eq 'true'}">
			<c:redirect url="http://javatpoint.com" />
		</c:when>
	</c:choose>





	<!--JSTL MySql Connection -->
	<h1>JSTL SQL Example</h1>
	<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/mydatabase" user="root" password="Satyam@#567" />

	
		<sql:query var="userList" dataSource="${dataSource}">  
	        SELECT * FROM users;
	    </sql:query>


			<c:forEach var="user" items="${userList.rows}">
				<p>User ID: ${user.id}</p>
				<p>User Name: ${user.name}</p>
				<p>User Email: ${user.email}</p> <hr>
			</c:forEach> <hr>
	

</body>
</html>
