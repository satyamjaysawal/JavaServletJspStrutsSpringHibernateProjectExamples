<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View Employees</title>
</head>
<body>
    <h1>List of Employees</h1>

    <ul>
        <c:forEach var="employee" items="${employeeList}">
            <li>
                <strong>First Name:</strong> ${employee.firstName}<br>
                <strong>Last Name:</strong> ${employee.lastName}<br>
                <strong>Email:</strong> ${employee.email}<br>
                <strong>City:</strong> ${employee.address.city}<br>
                <strong>District:</strong> ${employee.address.district}<br>
                <hr>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
