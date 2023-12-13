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
<%@include file="catalog.jsp" %>
<div class = "bookInfoForm">
        <form action="controller" method="GET">
            <input type="hidden" name="command" value="redirectToCatalog">
            <button id="button-hover" class="close-button"></button>
        </form>
        <c:choose>
            <c:when test="${not empty resMessage}">
                <p style="font-size: 35px">${resMessage}</p>
            </c:when>
            <c:when test="${user.roleName == 'USER'}">
                <div class = "bookInfo">
                    <h2 style="font-size: 35px">${bookTitle}</h2>
                    <p class="info-author">Автор книги: ${bookAuthor}</p>
                    <p class="info-rating">Рейтинг: ${bookRating}</p>
                    <div class="info-makeRequest">
                        <form display = "none" action="controller" method="POST">
                            <input type="hidden" name="command" value="bookrequestaddcommand">
                            <input type="hidden" name="id" value="${bookId}">
                            <input type="hidden" name="user" value="${user.id}">
                            <button id="button-hover" class="user-button-submit">Сделать заявку</button>
                        </form>
                    </div>
                </div>
            </c:when>
            <c:when test="${user.roleName == 'ADMIN'}">
                <div class = "bookInfo">
                    <h2 style=" font-size: 40px">${bookTitle}</h2>
                    <p class="info-author">Автор книги: ${bookAuthor}</p>
                    <p class="info-rating">Рейтинг: ${bookRating}</p>
                    <div class="info-makeRequest">
                        <form action="controller" method="POST">
                            <input type="hidden" name="command" value="deletebook">
                            <input type="hidden" name="id" value="${bookId}">
                            <button id="button-hover" class="user-button-submit">Удалить книгу</button>
                        </form>
                        <form action="controller" method="POST">
                            <input type="hidden" name="command" value="redirecttoeditbook">
                            <input type="hidden" name="id" value="${bookId}">
                            <input type="hidden" name="bookTitle" value="${bookTitle}">
                            <input type="hidden" name="bookAuthor" value="${bookAuthor}">
                            <input type="hidden" name="bookRating" value="${bookRating}">
                            <button id="button-hover" class="user-button-submit">Изменить информацию</button>
                        </form>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
</div>
</body>
</html>
