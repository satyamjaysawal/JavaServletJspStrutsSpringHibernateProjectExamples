<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Profile</title>
</head>
<body>
	<h2>Your Profile .... This is profile.jsp Page</h2>
	<h5> :: Isme username aur email /profile url ke through ProfileServlet.java se aa rha hai ::</h5>
    <p>Name: <%= request.getAttribute("username") %></p>
    <p>Email: <%= request.getAttribute("email") %></p>
    <br>
    <p><a href="index.jsp">Back to Home index.jsp</a></p><br><br>
    <p><a href="/index.jsp">Back to Home with Absolute path index.jsp</a><br>Absolute Path :: Url ko hit karega href="/index.jsp"  :: http://localhost:8086/index.jsp  :== HTTP Status 404 – Not Found</p>
    <p><a href="index.jsp">Back to Home with Relative path</a><br>Relative Path :: Url ko hit karega href="index.jsp"    ::  http://localhost:8086/AServletJSPUrl1(Project Name)/index.jsp</p>
    <p><a href="<%= request.getContextPath() %>/index.jsp">Back to Home with Context Path index.jsp</a><br> Context Path :: Url ko hit karega href=" request.getContextPath()/index.jsp"   :: http://localhost:8086/AServletJSPUrl1/index.jsp</p>


 <p><a href="AServletJSPUrl1/index.jsp">Back to Home index.jsp</a>   <br> Context Path :: Url ko hit karega href="AServletJSPUrl1/index.jsp"   :: http://localhost:8086/AServletJSPUrl1/AServletJSPUrl1/index.jsp :== HTTP Status 404 – Not Found</p>
     <p><a href="/AServletJSPUrl1/index.jsp">Back to Home index.jsp</a>   <br> Context & Absolute Path :: Url ko hit karega href="/AServletJSPUrl1/index.jsp"   :: http://localhost:8086/AServletJSPUrl1/index.jsp </p>
<br><br><br>

</body>
</html>