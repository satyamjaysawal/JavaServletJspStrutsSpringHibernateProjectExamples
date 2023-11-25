<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    
    <h1>Welcome, <bean:write name="username"/></h1>

    <jsp:include page="/footer.jsp"/>
</body>
</html>
