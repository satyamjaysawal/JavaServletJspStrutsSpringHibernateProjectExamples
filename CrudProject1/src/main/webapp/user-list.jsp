<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/list">Users</a>
            </li>
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">List of Users</h3>
            <hr>
            <div class="d-flex justify-content-between align-items-center">
                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
                <form method="post" action="<%=request.getContextPath()%>/search" class="form-inline">
                    <div class="form-group mx-sm-3 mb-2">
                        <input type="text" class="form-control" id="searchName" name="searchName" placeholder="Enter name">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Search</button>
                </form>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Country</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${listUser}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.country}" /></td>
                            <td>
                                <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
