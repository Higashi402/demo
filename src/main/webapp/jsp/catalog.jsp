<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <form id="book-request-form" action="controller" method="POST" accept-charset="UTF-8" style="display: none;">
            <input type="hidden" name="command" value="viewbookinformation">
            <input type="hidden" name="id" id="bookId">
            <input type="hidden" name="title" id="bookTitle">
            <input type="hidden" name="author" id="bookAuthor">
            <input type="hidden" name="rating" id="bookRating">
            <input type="submit" id="submitBtn" style="display: none;" formenctype="application/x-www-form-urlencoded;charset=UTF-8">
        </form>
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
                    <tr class='book-row' onclick="submitForm(this);" data-id="${bookEntry.key}" data-title="${bookEntry.value.title}" data-author="${bookEntry.value.author}" data-rating="${bookEntry.value.rating}">
                        <td>${bookEntry.value.title}</td>
                        <td>${bookEntry.value.author}</td>
                        <td>${bookEntry.value.rating}</td>
                    </tr>
                    <!-- Форма JSP для отправки запроса -->

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
