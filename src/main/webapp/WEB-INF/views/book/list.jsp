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
Lista książek
<br><br>
<a href="/book/form/add">Dodaj książkę</a>
<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Tytul</td>
        <td>Rating</td>
        <td>Opis</td>
        <td>Wydawca</td>
        <td>Autorzy</td>
        <td></td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher}</td>
            <td>${book.authors}</td>
            <td><a href="/book/form/edit/${book.id}">Edytuj</a> <a href="/book/form/confirm/${book.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
