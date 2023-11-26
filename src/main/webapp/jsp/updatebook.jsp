<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редактирование книги</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>
<%--<%@include file="header.jsp" %>--%>

<h2>Добавление книги</h2>
<div class = loginForm>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="updatebookcommand">
        <input type="hidden" id="titleValue" name="titleValue" value="">
        <input type="hidden" id="authorValue" name="authorValue" value="">
        <input type="hidden" id="ratingValue" name="ratingValue" value="">
        <input type="hidden" id="amountValue" name="amountValue" value="">
        <input type="hidden" name="id" value="${id}">

        <label for="title">Название книги:</label><br>
        <input type="text" id="title" name="title" required oninput="document.getElementById('titleValue').value = this.value;"><br><br>

        <label for="author">Автор книги:</label><br>
        <input type="text" id="author" name="author" required oninput="document.getElementById('authorValue').value = this.value;"><br><br>

        <label for="rating">Рейтинг книги:</label><br>
        <input type="number" id="rating" name="rating" min="1" max="10" step="0.1" required oninput="document.getElementById('ratingValue').value = this.value;"><br><br>

        <label for="amount">Количество:</label><br>
        <input type="number" id="amount" name="amount" min="1" max="10" required oninput="document.getElementById('amountValue').value = this.value;"><br><br>

        <input type="submit" value="Редактировать книгу">
    </form>
</div>
</body>
</html>