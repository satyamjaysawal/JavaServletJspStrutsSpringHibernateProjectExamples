<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="store.jsp" method="post">
        <label for="name">Name:</label> 
        <input type="text" name="name"><br><br>
        <label for="email">Email:</label>
        <input type="email" name="email"><br><br> 
        <input type="submit" name="submitClicked" value="Register">
    </form>
	
	
	<c:if test="${not empty param.name and not empty param.email}">
        <p>Name: ${param.name}</p>
        <p>Email: ${param.email}</p>
    </c:if>
	
    <c:choose>
        <c:when test="${not empty param.submitClicked}">
            <c:if test="${empty param.name or empty param.email}">
                <jsp:forward page="error.jsp" />
            </c:if>
        </c:when>
    </c:choose>
</body>
</html>
