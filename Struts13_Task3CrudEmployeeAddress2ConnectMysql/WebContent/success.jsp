<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Employee Information Saved Successfully</h1>

    <h2>Employee Details:</h2>
    <p>
        <strong>First Name:</strong> ${requestScope.name}<br>
        <strong>Email:</strong> ${requestScope.email}<br>
    </p>

    <h2>Address Details:</h2>
    <p>
        <strong>City:</strong> ${requestScope.address.city}<br>
        <strong>District:</strong> ${requestScope.address.district}<br>
    </p>

    <h2>List of Employees:</h2>
    <ul>
        <c:forEach var="employee" items="${requestScope.employeeList}">
            <li>
                <strong>First Name:</strong> ${employee.firstname} -
                <strong>Email:</strong> ${employee.email} -
                <strong>City:</strong> ${employee.address.city} -
                <strong>District:</strong> ${employee.address.district}
            </li>
        </c:forEach>
    </ul>
</body>
</html>
