<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Details Form</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <h1>User Details Form</h1>
    <form action="AddUserServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <input type="submit" value="Submit">
    </form>

    <jsp:include page="footer.jsp" />

    <%-- JSP Scriptlet --%>
    <% String currentTime = new java.util.Date().toString(); %>
    <p>Current Time: <%= currentTime %></p>
    
    <c:set var="userRole" value="admin" scope="session" />
    <p>User Role (Session Scoped): <c:out value="${userRole}" /></p>
    
    <c:if test="${empty param.name}">
        <p>Name is empty.</p>
    </c:if>
</body>
</html>
