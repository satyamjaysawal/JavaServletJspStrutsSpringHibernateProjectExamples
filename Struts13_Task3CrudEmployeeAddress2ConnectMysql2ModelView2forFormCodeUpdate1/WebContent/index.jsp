<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
    <title>Welcome to Your Struts Project</title>
</head>
<body>

    <h2>Welcome to Your Struts Project</h2>

    <p>This is the default landing page of your Struts application.</p>

    <!-- You can include links or actions to navigate to other parts of your application -->
    <p><a href="<html:rewrite page='/employee-form.jsp'/>">Go to Employee Form</a></p>

</body>
</html>
