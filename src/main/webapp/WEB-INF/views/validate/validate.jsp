<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 20.02.2021
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${errors.size() > 0}">
        <p>Komunikaty błędów</p>
        <c:forEach var="error" items="${errors}">
            ${error.getPropertyPath()} : ${error.getMessage()}<br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Walidacja prawidłowa</p>
    </c:otherwise>
</c:choose>
</body>
</html>
