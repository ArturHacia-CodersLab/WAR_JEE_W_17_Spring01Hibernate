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
${message}
<br><br>
Lista wydawców
<br><br>
<a href="/publisher/form/add">Dodaj wydawcę</a>
<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Nazwa</td>
        <td>NIP</td>
        <td>Regon</td>
        <td></td>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>
            <td>${publisher.nip}</td>
            <td>${publisher.regon}</td>
            <td><a href="/publisher/form/edit/${publisher.id}">Edytuj</a> <a href="/publisher/form/confirm/${publisher.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
