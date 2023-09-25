<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Employee Details</h2>
        <c:if test="${employee != null}">
            <dl class="row">
                <dt class="col-sm-3">ID:</dt>
                <dd class="col-sm-9"><c:out value="${employee.id}" /></dd>

                <dt class="col-sm-3">Name:</dt>
                <dd class="col-sm-9"><c:out value="${employee.firstname} ${employee.lastname}" /></dd> <!-- Display both first name and last name -->

                <dt class="col-sm-3">Email:</dt>
                <dd class="col-sm-9"><c:out value="${employee.email}" /></dd>

                <dt class="col-sm-3">Country:</dt>
                <dd class="col-sm-9"><c:out value="${employee.country}" /></dd>

                <dt class="col-sm-3">Gender:</dt>
                <dd class="col-sm-9"><c:out value="${employee.gender}" /></dd>

                <dt class="col-sm-3">Address:</dt>
                <dd class="col-sm-9">
                    <span style="color: blue;">Street Address:</span> <c:out value="${employee.address.streetAddress}" /><br>
                    <span style="color: green;">Apartment:</span> <c:out value="${employee.address.apartment}" /><br>
                    <span style="color: red;">City:</span> <c:out value="${employee.address.city}" /><br>
                    <span style="color: purple;">State:</span> <c:out value="${employee.address.state}" /><br>
                    <span style="color: orange;">Postal Code:</span> <c:out value="${employee.address.postalCode}" /><br>
                    <span style="color: brown;">Landmark:</span> <c:out value="${employee.address.landmark}" />
                </dd>

                <dt class="col-sm-3">Phone Number:</dt>
                <dd class="col-sm-9"><c:out value="${employee.phoneNumber}" /></dd>

                <dt class="col-sm-3">Department ID:</dt>
                <dd class="col-sm-9"><c:out value="${employee.departmentId}" /></dd>

                <dt class="col-sm-3">Job Title:</dt>
                <dd class="col-sm-9"><c:out value="${employee.jobTitle}" /></dd>

                <dt class="col-sm-3">Salary:</dt>
                <dd class="col-sm-9"><c:out value="${employee.salary}" /></dd>

                <dt class="col-sm-3">Work Location:</dt>
                <dd class="col-sm-9"><c:out value="${employee.workLocation}" /></dd>
            </dl>
        </c:if>
        <p>
            <a href="edit?id=<c:out value='${employee.id}' />" class="btn btn-primary">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0);" onclick="showFunction(${employee.id})" class="btn btn-danger">Delete</a>
        </p>
        <a href="<%=request.getContextPath()%>/list" class="btn btn-secondary">Back to Employee List</a>
    </div>

    <script>
        function showFunction(employeeId) {
            if (confirm("Are you sure you want to delete this employee?")) {
               
                window.location.href = "delete?id=" + employeeId;
            } else {
                
                return false;
            }
        }
    </script>
</body>
</html>
