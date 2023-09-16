<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>

<sql:setDataSource
    var="dataSource"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/mydatabase"
    user="root"
    password="Satyam@#567"
/>

<c:if test="${not empty param.name and not empty param.email}">
    <sql:update dataSource="${dataSource}">
        INSERT INTO users (name, email) VALUES (?, ?)
        <sql:param value="${param.name}" />
        <sql:param value="${param.email}" />
    </sql:update>
</c:if>

<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
    <jsp:include page="/index.jsp" />
    
    <h1>Registration Successful</h1>
    <p>User information has been stored in the database.</p>
    <a href="index.jsp">Back to Registration</a>


    <!-- Add a submit button to return to the registration page -->
    <form action="JspJstlTagsExamples.jsp" method="get">
        <br>
        <input type="submit" value="Go to the JStl tags Examples Page">
    </form>
    
    
    
     <!-- Extra submit button to send data to AddServlet -->
    <form action="AddStudentServlet" method="post">
        <input type="hidden" name="name" value="${param.name}" />
        <input type="hidden" name="email" value="${param.email}" />
        <input type="submit" value="Submit to AddStudentServlet">
    </form>
     
</body>
</html>
