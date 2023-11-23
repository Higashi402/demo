<%--
  Created by IntelliJ IDEA.
  User: Higashi
  Date: 23.11.2023
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Каталог книг</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>

<div id="booksContainer">
    <table style="width: 900px;">
        <thead>
        <tr>
            <th style="width: 250px;">Название книги</th>
            <th style="width: 150px;">Автор книги</th>
            <th style="width: 100px;">Рейтинг</th>
        </tr>
        </thead>
        <tbody id="bookTableBody">
        <c:forEach var="bookEntry" items="${bookDictionary}">
            <tr>
                <td hidden>${bookEntry.key}</td>
                <td>${bookEntry.value.title}</td>
                <td>${bookEntry.value.author}</td>
                <td>${bookEntry.value.rating}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>