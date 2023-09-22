<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Details</title>
</head>
<body>
	<h2>Employee Details</h2>
	<c:if test="${employee != null}">
		<p>
			<strong>ID:</strong>
			<c:out value="${employee.id}" />
		</p>
		<p>
			<strong>Name:</strong>
			<c:out value="${employee.name}" />
		</p>
		<p>
			<strong>Email:</strong>
			<c:out value="${employee.email}" />
		</p>
		<p>
			<strong>Country:</strong>
			<c:out value="${employee.country}" />
		</p>
	</c:if>
	<a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:void(0);"
		onclick="showConfirmationPopup(${employee.id})">Delete</a>
</body>
   <script>
    function showConfirmationPopup(employeeId) {
        if (confirm("Are you sure you want to delete this employee?")) {
            // If the user clicks "OK," proceed with deletion
            window.location.href = "delete?id=" + employeeId;
        } else {
            // If the user clicks "Cancel," do nothing
            return false;
        }
    }
  </script>
</html>
