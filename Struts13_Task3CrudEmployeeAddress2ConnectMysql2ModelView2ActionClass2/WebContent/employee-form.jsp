<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
<head>
    <title>Employee Information Form</title>
</head>
<body>
    <h1>Employee Information Form</h1>

    <html:form action="saveEmployee.do" method="post">
    <p>form action="/saveEmployee"  or form action="saveEmployee.do"</p>
        <!-- Employee details -->
        <label for="firstName">First Name:</label>
        <html:text property="firstName" /><br>

        <label for="lastName">Last Name:</label>
        <html:text property="lastName" /><br>

        <label for="email">Email:</label>
        <html:text property="email" /><br>

        <!-- Address details -->
        <label for="address.city">City:</label>
        <html:text property="address.city" /><br>

        <label for="address.district">District:</label>
        <html:text property="address.district" /><br>

        <!-- Submission button -->
        <html:submit value="Submit"/>
    </html:form>
    <br><br>
    <a href="viewEmployees.do" > Go To ViewEmployee List = href="viewEmployees.do"</a>
</body>
</html>
