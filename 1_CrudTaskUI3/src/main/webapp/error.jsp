<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-5">
    <div class="alert alert-danger">
        <h2 class="alert-heading">An Error Occurred</h2>
        <p>${error}</p>
    </div>
    <a href="<%= request.getContextPath() %>/list" class="btn btn-primary">Back to Employee List</a>
  </div>
</body>
</html>
