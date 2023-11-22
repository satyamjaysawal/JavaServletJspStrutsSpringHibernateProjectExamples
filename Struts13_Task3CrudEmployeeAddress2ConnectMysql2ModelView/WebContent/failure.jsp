<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error occurred while saving employee information</h1>
    <!-- You can add more content here as needed -->
    <h2>Error Details :</h2>
    
    <p>  Error Type (requestScope.error) : ${requestScope.error}   </p>
     <p>  Error Type(error) : ${error}   </p>
</body>
</html>
