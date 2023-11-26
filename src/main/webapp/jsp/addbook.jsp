<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 26.11.2023
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление книги</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>
<%--<%@include file="header.jsp" %>--%>

<h2>Добавление книги</h2>
<div class = loginForm>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="addbookscommand">
        <input type="hidden" id="titleValue" name="titleValue" value="">
        <input type="hidden" id="authorValue" name="authorValue" value="">
        <input type="hidden" id="amountValue" name="amountValue" value="">

        <label for="title">Название книги:</label><br>
        <input type="text" id="title" name="title" required oninput="document.getElementById('titleValue').value = this.value;"><br><br>

        <label for="author">Автор книги:</label><br>
        <input type="text" id="author" name="author" required oninput="document.getElementById('authorValue').value = this.value;"><br><br>

        <label for="amount">Количество:</label><br>
        <input type="number" id="amount" name="amount" min="1" max="10" required oninput="document.getElementById('amountValue').value = this.value;"><br><br>

        <input type="submit" value="Добавить книгу">
    </form>
</div>
</body>
</html>