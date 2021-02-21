<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 20.02.2021
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    Nazwa: <form:input path="name"/><br>
    <form:errors path="name"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
