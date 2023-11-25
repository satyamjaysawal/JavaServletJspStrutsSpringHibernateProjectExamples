<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
<head>
    <title>Employee Registration Form</title>
</head>
<body>

    <h2>Employee Registration Form</h2>

    <!-- Display any error messages here -->
    <html:errors/>

    <!-- ActionForm for the form -->
    <html:form action="/saveEmployee" method="post">

        <!-- Input fields for employee information -->
        <label for="firstName">First Name:</label>
        <html:text property="firstName" size="20"/>
        <br>

        <label for="lastName">Last Name:</label>
        <html:text property="lastName" size="20"/>
        <br>

        <label for="street">Street:</label>
        <html:text property="street" size="20"/>
        <br>

        <label for="city">City:</label>
        <html:text property="city" size="20"/>
        <br>

        <label for="state">State:</label>
        <html:text property="state" size="20"/>
        <br>

        <label for="zipCode">Zip Code:</label>
        <html:text property="zipCode" size="10"/>
        <br>

        <!-- Submit button -->
        <html:submit value="Save"/>

    </html:form>

</body>
</html>
