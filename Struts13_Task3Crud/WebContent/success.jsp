<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Form Submitted Successfully</h1>
    <p>Employee information has been successfully submitted. Thank you!</p>
    <h2>Employee Details:</h2>
    <p>First Name: <%= request.getAttribute("firstname") %></p>
    <p>Last Name: <%= request.getAttribute("lastname") %></p>
    <p>Email: <%= request.getAttribute("email") %></p>

    <h2>Address Details:</h2>
    <p>City: <%= request.getAttribute("address.city") %></p>
    <p>District: <%= request.getAttribute("address.district") %></p>
</body>
</html>
