<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="/header.jsp"/>
    
    <html:form action="/login">
        <label>Username: <html:text property="username" /></label><br>
        <label>Password: <html:password property="password" /></label><br>
        <html:submit />
    </html:form>

    <jsp:include page="/footer.jsp"/>
</body>
</html>
