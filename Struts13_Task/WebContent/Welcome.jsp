<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome</h1>
    <p>Name: <%= request.getAttribute("name") %></p>
    <p>Email: <%= request.getAttribute("email") %></p>
</body>
</html>
