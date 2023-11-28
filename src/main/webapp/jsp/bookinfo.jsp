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
<%@include file="header.jsp" %>
<div class = "bookInfoForm" class="modal">

        <form action="controller" method="POST">
            <input type="hidden" name="command" value="close">
            <button id="button-hover" class="close-button"></button>
        </form>
        <c:choose>
            <c:when test="${not empty resMessage}">
                <p style="font-size: 35px">${resMessage}</p>
            </c:when>
            <c:otherwise>
                <div class = "bookInfo"> </div>
                    <h2>${bookTitle}</h2>
                    <p class="info-author">Автор тест: ${bookAuthor}</p>
                    <p class="info-rating">Рейтинг: ${bookRating}</p>
                    <div class="info-makeRequest">
                        <form action="controller" method="POST">
                            <input type="hidden" name="command" value="bookrequestaddcommand">
                            <input type="hidden" name="id" value="${bookId}">
                            <button id="button-hover">Сделать заявку</button>
                        </form>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
</div>
</body>
</html>
