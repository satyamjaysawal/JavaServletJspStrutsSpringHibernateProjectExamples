<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar h2 navbar-light" style="background-color: #e3f2fd">
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
                    <%
                        List<User> listUser = (List<User>) request.getAttribute("listUser");
                        if (listUser != null) {
                            for (User user : listUser) {
                    %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getCountry() %></td>
                        <td>
                            <a href="edit?id=<%= user.getId() %>">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<%= user.getId() %>">Delete</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
