
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Заявки</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<%@include file="header.jsp" %>

<div id="viewBooksForm" class="modal common-form-style" style="display: block;">
    <div class="modal-content-catalog" id="viewBooksContent" style="display: flex; flex-direction: column; align-items: center; width: 100%;">

    <div class="close-button" id="button-hover" onclick="closeForm('viewBooksForm')"></div>

            <form action="controller" method="get">
                <input type="hidden" name="command" value="close">
                <button id="button-hover" class="close-button"></button>
            </form>

            <h2 style="text-align: center; font-size: 40px;">Список книг</h2>
            <div id="booksContainer">
                <table style="width: 700px;">
                    <thead>
                    <tr>
                        <th>Название книги</th>
                        <th style="width: 200px;">Автор книги</th>
                        <th style="width: 200px;">Рейтинг</th>
                    </tr>
                    </thead>
                    <tbody id="bookTableBody">
                    <c:forEach var="bookEntry" items="${bookDictionary}">
                        <tr onclick="displayBookInfo(this)" data-title="${bookEntry.value.title}" data-author="${bookEntry.value.author}" data-rating="${bookEntry.value.rating}">
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

<div id="bookInfo" style="display: none;">
    <div class="modal-content-catalog"></div>
    <h2>Информация о книге:</h2>
    <form id="bookInfoForm">
        <p><strong>Название:</strong> <span id="bookTitle"></span></p>
        <p><strong>Автор:</strong> <span id="bookAuthor"></span></p>
        <p><strong>Рейтинг:</strong> <span id="bookRating"></span></p>
    </form>
</div>


</body>
</html>












