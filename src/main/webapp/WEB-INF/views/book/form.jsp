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
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    Tytuł: <form:input path="title"/><br>
    <form:errors path="title"/><br>
    Rating: <form:input type="number" path="rating"/><br>
    <form:errors path="rating"/><br>
    Opis: <form:textarea path="description"/><br>
    <form:errors path="description"/><br>
    Wydawca: <form:select path="publisher">
        <form:option value="0">-- wybierz --</form:option>
        <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="publisher"/><br>
    Autorzy: <form:select path="authors" multiple="true" items="${authors}" itemValue="id" itemLabel="fullName"/><br>
    <form:errors path="authors"/><br>
    Liczba stron: <form:input type="number" path="pages"/><br>
    <form:errors path="pages"/><br>
    Kategoria: <form:select path="category">
    <form:option value="0">-- wybierz --</form:option>
    <form:options items="${categories}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="category"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
