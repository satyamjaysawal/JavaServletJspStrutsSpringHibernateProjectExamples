<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar h2 navbar-light " style="background-color: #2CE2D0 ">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/list">Users</a>
            </li>
        </ul>
    </nav>
</header>
<br>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <% if (request.getAttribute("user") != null) { %>
                <form action="update" method="post">
            <% } else { %>
                <form action="insert" method="post">
            <% } %>

            <h2>
                <% if (request.getAttribute("user") != null) { %>
                    Edit User
                <% } else { %>
                    Add New User
                <% } %>
            </h2>

            <% if (request.getAttribute("user") != null) { %>
                <input type="hidden" name="id" value="<%=((User)request.getAttribute("user")).getId() %>" />
            <% } %>

            <fieldset class="form-group">
                <label>User Name</label>
                <input type="text"
                       value="<%= request.getAttribute("user") != null ? ((User)request.getAttribute("user")).getName() : "" %>"
                       class="form-control"
                       name="name"
                       required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>User Email</label>
                <input type="email"
                       value="<%= request.getAttribute("user") != null ? ((User)request.getAttribute("user")).getEmail() : "" %>"
                       class="form-control"
                       name="email"
                       required="required"
                       placeholder="sophie@example.com"
                       pattern="[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*"
                       title="Enter a valid email address">
            </fieldset>

            <fieldset class="form-group">
                <label>User Country</label>
                <input type="text"
                       value="<%= request.getAttribute("user") != null ? ((User)request.getAttribute("user")).getCountry() : "" %>"
                       class="form-control"
                       name="country">
            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
            </form> <!-- Closing form tag -->
        </div>
    </div>
</div>
</body>
</html>
