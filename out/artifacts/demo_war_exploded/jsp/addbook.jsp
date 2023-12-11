<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
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
<%@include file="header.jsp" %>
<%@include file="catalog.jsp"%>

<h2>Добавление книги</h2>
<div class = adminAddBookForm>
    <form action="controller" method="GET">
        <input type="hidden" name="command" value="viewbooks">
        <button id="button-hover" class="close-button"></button>
    </form>
    <form action="controller" method="POST">
        <input type="hidden" name="command" value="addbook">
        <input type="hidden" id="titleValue" name="titleValue" value="">
        <input type="hidden" id="authorValue" name="authorValue" value="">
        <input type="hidden" id="amountValue" name="amountValue" value="">

        <div class = "add-book-text-box">
            <label for="title" style="font-size: 25px; margin-bottom: 20px">Название книги:</label>
            <input type="text" id="title" name="title" required oninput="document.getElementById('titleValue').value = this.value;">

            <label for="author" style="font-size: 25px; margin-bottom: 20px">Автор книги:</label>
            <input type="text" id="author" name="author" required oninput="document.getElementById('authorValue').value = this.value;">

            <label for="amount" style="font-size: 25px; margin-right: 20px">Количество:</label>
            <input type="number" id="amount" name="amount" min="1" max="10" required oninput="document.getElementById('amountValue').value = this.value;">
        </div>

        <input type="submit" class = "admin-add-book" id = "button-hover" value="Добавить книгу">
    </form>
</div>
</body>
</html>