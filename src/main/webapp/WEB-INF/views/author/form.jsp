<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 07.02.2021
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    Imię: <form:input path="firstName"/><br>
    <form:errors path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName"/><br>
    PESEL: <form:input path="pesel"/><br>
    <form:errors path="pesel"/><br>
    Email: <form:input path="email"/><br>
    <form:errors path="email"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
