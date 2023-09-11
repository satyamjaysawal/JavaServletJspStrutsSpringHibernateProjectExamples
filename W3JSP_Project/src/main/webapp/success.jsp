<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <h1>Success</h1>
    <p>Data submitted successfully!</p>

    <jsp:include page="footer.jsp" />

    <hr>

<%-- JSP Scriptlet --%>
<%
    int randomNum = (int) (Math.random() * 100);
    pageContext.setAttribute("randomNum", randomNum);
    out.println("Random Number: " + randomNum);
%>

<c:choose>
    <c:when test="${randomNum % 2 == 0}">
        <p>Random Number is even.</p>
    </c:when>
    <c:otherwise>
        <p>Random Number is odd.</p>
    </c:otherwise>
</c:choose>


</body>
</html>
