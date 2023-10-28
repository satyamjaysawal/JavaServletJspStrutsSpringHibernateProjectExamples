<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Information</title>
</head>
<body>
    <h1>Employee Information</h1>
    <form action="save.do" method="post">
        <!-- Employee details -->
        <label for="firstname">First Name:</label>
        <input type="text" name="firstname" required><br>
        <label for="lastname">Last Name:</label>
        <input type="text" name="lastname" required><br>
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>
        
        <!-- Address details -->
        <label for="city">City:</label>
        <input type="text" name="address.city" required><br>
        <label for="district">District:</label>
        <input type="text" name="address.district" required><br>
        
        <!-- Submission button -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>
