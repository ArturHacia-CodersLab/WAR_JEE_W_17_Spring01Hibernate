<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 07.02.2021
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Czy na pewno chcesz usunąc autora o id ${id}
<br><br>
<a href="/author/form/all">Nie</a> <a href="/author/form/delete/${id}">Tak</a>
</body>
</html>
