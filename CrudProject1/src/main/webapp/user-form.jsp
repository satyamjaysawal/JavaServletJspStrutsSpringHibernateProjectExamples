<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:choose>
                <c:when test="${user != null}">
                    <form action="update" method="post">
                </c:when>
                <c:otherwise>
                    <form action="insert" method="post">
                </c:otherwise>
            </c:choose>

            <h2>
                <c:choose>
                    <c:when test="${user != null}">
                        Edit User
                    </c:when>
                    <c:otherwise>
                        Add New User
                    </c:otherwise>
                </c:choose>
            </h2>

            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>User Name</label>
                <input type="text"
                       value="<c:out value='${user.name}' />"
                       class="form-control"
                       name="name"
                       required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>User Email</label>
                <input type="email"
                       value="<c:out value='${user.email}' />"
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
                       value="<c:out value='${user.country}' />"
                       class="form-control"
                       name="country">
            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
</div>
</div>
</body>
</html>
