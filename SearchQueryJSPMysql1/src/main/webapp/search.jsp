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

<html>
<head>
    <title>User Search</title>
</head>
<body>
    <h1>User Search</h1>
    
    <form method="post" action="search.jsp">
        <label for="search">Search by Name:</label>
        <input type="text" id="search" name="searchName" />
        <input type="submit" value="Search" />
    </form>

    <c:if test="${not empty param.searchName}">
        <h2>Search Results:</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
            <sql:query dataSource="${dataSource}" var="result">
                SELECT * FROM users WHERE name LIKE ?
                <sql:param value="%${param.searchName}%" />
            </sql:query>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td>${row.id}</td>
                    <td>${row.name}</td>
                    <td>${row.email}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
