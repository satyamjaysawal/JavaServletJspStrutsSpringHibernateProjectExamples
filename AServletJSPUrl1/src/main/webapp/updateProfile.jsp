<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Update Your Profile</h2>
    <h4>http://localhost:8086/AServletJSPUrl1/profile?action=update   :: <br> Ye ProfileServlet.java se 'action=update' perform krta hai jo updateProfile.jsp pr jata hai</h4>
    <form action="profile" method="post">
    	<h4>form action="profile" method="post" ==> ProfileServlet.java </h4>
        <label for="username">Name:</label>
        <input type="text" id="username" name="username" value="<%= request.getAttribute("username") %>" required>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= request.getAttribute("email") %>" required>
        <input type="hidden" name="action" value="update">
        <input type="submit" value="Update">
    </form>
    <p><a href="index.jsp">Back to Home  :: href="index.jsp"</a></p>
</body>
</html>