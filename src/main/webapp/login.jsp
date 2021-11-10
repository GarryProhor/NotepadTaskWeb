<%@ page import="by.prohor.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>LOGIN PAGE</title>
</head>
<body>
<h2>Authorization</h2>
<c:if test ="${not empty message}">
    <p style="color: #ff0000">${message}</p>
</c:if>
<form method="post" action="<c:url value="<%=AppConstant.AUTHORIZATION%>"/>">
    <input type="text" name="<%=AppConstant.LOGIN_LABEL%>>" placeholder="Login">
    <input type="password" name="<%=AppConstant.PASSWORD_LABEL%>>" placeholder="Password">
    <input type="submit" value="LogIn">
</form>
</body>
</html>
