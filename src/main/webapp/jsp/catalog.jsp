<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Каталог книг</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<%@include file="header.jsp" %>

<div class="viewBooksForm" class="modal">
    <div class="modal-content-catalog">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="close">
            <button id="button-hover" class="close-button"></button>
        </form>



        <div class = "head">
            <h2 style="text-align: center; font-size: 40px; margin-bottom: 10px;">Каталог книг</h2>
            <% if (request.getAttribute("resMessage") != null) { %>
            <h1 class="message-heading">${resMessage}</h1>
            <% } %>
        </div>
        <div id="booksContainer">
            <table style="width: 700px; font-size: 20px;">
                <thead>
                <tr style="font-size: 30px;">
                    <th>Название книги</th>
                    <th style="width: 200px;">Автор книги</th>
                    <th style="width: 200px;">Рейтинг</th>
                </tr>
                </thead>
                <tbody class="tableBody">
                <c:forEach var="bookEntry" items="${bookDictionary}">
                    <tr class='book-row' onclick="displayBookInfo(this)" data-id="${bookEntry.key}" data-title="${bookEntry.value.title}" data-author="${bookEntry.value.author}" data-rating="${bookEntry.value.rating}">
                        <td hidden>${bookEntry.key}</td>
                        <td>${bookEntry.value.title}</td>
                        <td>${bookEntry.value.author}</td>
                        <td>${bookEntry.value.rating}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
