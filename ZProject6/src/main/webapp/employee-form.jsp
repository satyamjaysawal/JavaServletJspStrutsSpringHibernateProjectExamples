<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar h2 navbar-light" style="background-color: #e3f2fd">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/list">Employees</a>
            </li>
        </ul>
    </nav>
</header>
<br>

<div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:choose>
                    <c:when test="${employee != null}">
                        <form action="update" method="post">
                    </c:when>
                    <c:otherwise>
                        <form action="insert" method="post">
                    </c:otherwise>
                </c:choose>

                <h2>
                    <c:choose>
                        <c:when test="${employee != null}">
                            Edit Employee
                        </c:when>
                        <c:otherwise>
                            Add New Employee
                        </c:otherwise>
                    </c:choose>
                </h2>

                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>

                <fieldset class="form-group">
                    <label>Employee Name</label>
                    <input type="text"
                           value="<c:out value='${employee.name}' />"
                           class="form-control"
                           name="name"
                           required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Employee Email</label>
                    <input type="email"
                           value="<c:out value='${employee.email}' />"
                           class="form-control"
                           name="email"
                           required="required"
                           placeholder="johndoe@example.com"
                           pattern="[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*"
                           title="Enter a valid email address">
                </fieldset>

                <fieldset class="form-group">
                    <label>Employee Country</label>
                    <input type="text"
                           value="<c:out value='${employee.country}' />"
                           class="form-control"
                           name="country">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                <a href="<%=request.getContextPath()%>/list" class="btn btn-secondary">Cancel</a>
                </form> <!-- Closing form tag -->
            </div>
        </div>
    </div>
</body>
</html>
