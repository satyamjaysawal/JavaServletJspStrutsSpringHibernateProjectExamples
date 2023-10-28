<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:form action="/login">
    <html:text property="email" />
    <html:password property="password" />
    <html:submit value="Login" />
</html:form>
