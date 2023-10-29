<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
    <h2>Welcome, <%=(String) session.getAttribute("user")%>!</h2>
    <a href="LogoutServlet">Logout</a>
</body>
</html>
