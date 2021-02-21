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
<form:form method="post" modelAttribute="publisher">
    <form:hidden path="id"/>
    Nazwa: <form:input path="name"/><br>
    <form:errors path="name"/><br>
    NIP: <form:input path="nip"/><br>
    <form:errors path="nip"/><br>
    REGON: <form:input path="regon"/><br>
    <form:errors path="regon"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
