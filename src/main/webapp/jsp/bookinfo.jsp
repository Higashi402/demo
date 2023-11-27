<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
    <title>Информация о книге</title>
    <meta charset="UTF-8">
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<div class = "bookInfoForm">
    <button class="close-button" onclick="closeForm()"></button>
    <h2>${bookTitle}</h2>
    <p>Автор тест: ${bookAuthor}</p>
    <p>Рейтинг: ${bookRating}</p>
    <form action="controller" method="POST">
        <input type="hidden" name="command" value="bookrequestaddcommand">
        <input type="hidden" name="id" value="${bookId}">
        <button  id="button-hover" onclick="submitForm()" >Сделать заявку</button>
    </form>
</div>
</body>
</html>
