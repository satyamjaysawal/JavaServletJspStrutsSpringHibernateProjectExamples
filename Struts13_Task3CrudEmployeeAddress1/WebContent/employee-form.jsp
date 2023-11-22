<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
<head>
    <title>Employee Information</title>
</head>
<body>
    <h1>Employee Information</h1>

    <html:form action="/save" method="post">
        <!-- Employee details -->
        <label for="firstname">First Name:</label>
        <html:text property="firstname" /><br>

        <label for="lastname">Last Name:</label>
        <html:text property="lastname" /><br>

        <label for="email">Email:</label>
        <html:text property="email" /><br>

        <!-- Address details -->
        <label for="city">City:</label>
        <html:text property="address.city" /><br>

        <label for="district">District:</label>
        <html:text property="address.district" /><br>

        <!-- Submission button -->
        <html:submit value="Submit"/>
    </html:form>
</body>
</html>
