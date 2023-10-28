<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, ${name}</h1>
    <p>Email: ${email}</p>
    <p>Password: ${password}</p>

    <h2>User Data:</h2>
    <ul>
        <c:forEach var="data" items="${userData}">
            <li>${data}</li>
        </c:forEach>
    </ul>
</body>
</html>
