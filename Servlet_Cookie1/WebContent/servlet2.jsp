<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Name</title>
</head>
<body>
    <%-- Retrieving the name from the ServletTwo --%>
    <% 
        String name = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    name = cookie.getValue();
                }
            }
        }
    %>
    <h2>Welcome <%= name %>!</h2>
</body>
</html>
