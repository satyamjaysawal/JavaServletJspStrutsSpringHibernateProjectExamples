<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Employee Information Saved Successfully</h1>

    <h2>Employee Details:</h2>
    <p>
        <strong>Name:</strong> FirstName + LastName : ${name}<br>
        <strong>Email:</strong> ${email}<br>
    </p>

    <h2>Address Details:</h2>
    <p>
        <strong>City:</strong> ${address.city}<br>
        <strong>District:</strong> ${address.district}<br>
    </p>

    <h2>List of Employees:</h2>
    <ul>
        <c:forEach var="employee" items="${employeeList}">
            <li>${employee.firstName} - ${employee.email}</li>
        </c:forEach>
    </ul>
</body>
</html>
