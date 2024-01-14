<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Выдачи книг</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<%@include file="issuances.jsp" %>
<div class = "bookInfoForm">
    <form action="controller" method="GET">
        <input type="hidden" name="command" value="redirecttoissuances">
        <button id="button-hover" class="close-button"></button>
    </form>
    <div class = "bookInfo">

        <h2 style="font-size: 35px">${bookTitle}</h2>
        <p class="info-author">Номер заявки: ${issuanceId}</p>
        <p class="info-rating">Читатель: ${userLogin}</p>
        <p class="info-rating">Книга: ${bookTitle}</p>
        <p class="info-rating">Автор книги: ${bookAuthor}</p>
        <p class="info-rating">Дата выдачи: ${issuanceDate}</p>
        <p class="info-rating">Дата возврата: ${actualReturningDate}</p>
        <div class="info-makeRequest">
            <form display = "none" action="controller" method="GET">
                <input type="hidden" id="issuancedate" name="issuancedate" value="">
                <input type="hidden" id="returningdate" name="returningdate" value="">

                <label style="font-size: 25px; margin-bottom: 20px">Установить дату выдачи:</label>
                <input type="date" id="issuancedateField" name="issuancedateField">
                <label style="font-size: 25px; margin-bottom: 20px">Установить дату возврата:</label>
                <input type="date" id="returningdateField" name="returningdateField">

                <input type="hidden" name="command" value="editissuancedates">
                <input type="hidden" name="issuanceId" value="${issuanceId}">
                <input type="submit" class="user-button-submit" style="display: flow; position: relative; left: 20%" id="button-hover" value="Изменить даты" onclick="changeIssuanceDates()">
            </form>
        </div>
    </div>
</div>
</body>
</html>
