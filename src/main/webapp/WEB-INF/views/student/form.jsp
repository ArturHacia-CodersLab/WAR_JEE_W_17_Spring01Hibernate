<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 07.02.2021
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    Imię: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    Płeć:<br>
    <form:radiobutton path="gender" value="F" label="Kobieta"/><br>
    <form:radiobutton path="gender" value="M" label="Mężczyzna"/><br>
    Kraj: <form:select path="country">
        <form:option value="-" label="-- wybierz kraj --"/>
        <form:options items="${countries}"/>
    </form:select><br>
    Notatki: <form:textarea path="notes" cols="20" rows="5"/><br>
    <form:checkbox path="mailingList" label="Lista mailingowa" value="true"/><br>
    Programowanie: <form:select path="programmingSkills" multiple="true" items="${programmingSkills}"/><br>
    Hobby:<br>
    <form:checkboxes path="hobbies" items="${hobbies}" element="div"/>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
