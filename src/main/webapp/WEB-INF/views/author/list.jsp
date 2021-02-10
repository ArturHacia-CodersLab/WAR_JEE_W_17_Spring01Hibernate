<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 07.02.2021
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Lista autorów
<br><br>
<a href="/author/form/add">Dodaj autora</a>
<br><br>
<table border="1">
    <tr>
    <td>Id</td>
    <td>Imię</td>
    <td>Nazwisko</td>
    <td></td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/author/form/edit/${author.id}">Edytuj</a> <a href="/author/form/confirm/${author.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
