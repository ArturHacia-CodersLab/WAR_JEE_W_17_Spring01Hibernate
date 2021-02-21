<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 20.02.2021
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Lista kategori
<br><br>
<a href="/category/form/add">Dodaj kategorię</a>
<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Nazwa</td>
        <td></td>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td><a href="/category/form/edit/${category.id}">Edytuj</a> <a href="/category/form/confirm/${category.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
