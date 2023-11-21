<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>URL Rewriting Example   </title>
</head>
<body>
	<h2>Welcome to Profile App index.jsp Page </h2>
	<h4>... Url pr hai :: http://localhost:8086/AServletJSPUrl1/</h4>
	<h4>... Url pr hai :: http://localhost:8086/AServletJSPUrl1/index.jsp</h4>
	
	<br><br>
    <p><a href="profile">View Profile</a>   <br> Relative Path :: Url ko hit karega href="profile"    ::  http://localhost:8086/AServletJSPUrl1(Project Name)/profile</p>
    <p><a href="/profile">View Profile</a>   <br> Absolute Path :: Url ko hit karega href="/profile"   :: http://localhost:8086/profile :== HTTP Status 404 – Not Found</p>
    <p><a href="<%= request.getContextPath() %>/profile">View Profile with Context Path</a><br> Context Path :: Url ko hit karega href=" request.getContextPath()/profile"   :: http://localhost:8086/AServletJSPUrl1/profile</p>
    
    <p><a href="AServletJSPUrl1/profile">View Profile</a>   <br> Context Path :: Url ko hit karega href="AServletJSPUrl1/profile"   :: http://localhost:8086/AServletJSPUrl1/AServletJSPUrl1/profile :== HTTP Status 404 – Not Found</p>
     <p><a href="/AServletJSPUrl1/profile">View Profile</a>   <br> Context & Absolute Path :: Url ko hit karega href="/AServletJSPUrl1/profile"   :: http://localhost:8086/AServletJSPUrl1/profile </p>
   <br>
   <br>
   <p><a href="profile?action=update">Update Action Profile</a><br> Relative Action Path  :: Url ko hit karega href="profile?action=update"   ::  http://localhost:8086/AServletJSPUrl1/profile?action=update</p>
   
   <br>
   <p><a href="update">Update Profile</a><br> Relative Action Path  :: Url ko hit karega href="update"  ::  http://localhost:8086/AServletJSPUrl1/update</p>
   
   <br>
   <p><a href="/updateProfile.jsp">Update /updateProfile.jsp Profile</a><br> Relative Action Path  :: Url ko hit karega href="update"  ::  http://localhost:8086/AServletJSPUrl1/update</p>
<br><br><br>
		
</body>
</html>