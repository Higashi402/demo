<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<div class="black-line-container">
    <hr class="user-black-line">
    <div class="user-centered-text">E-Book</div>
</div>
    <c:choose>
        <c:when test="${sessionScope.userRole eq 'USER'}">
            <div class = "user-buttons">
                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="viewbooks">
                    <button type="submit" id="button-hover" class="user-buttons-catalog">Просмотр каталога книг</button>
                </form>

                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="viewrequests">
                    <button type="submit" id="button-hover" class="user-buttons-request">Просмотр заявок</button>
                </form>

                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="logout">
                    <button type="submit" id="button-hover" class="user-buttons-exit"></button>
                </form>
            </div>
        </c:when>
        <c:when test="${sessionScope.userRole eq 'ADMIN'}">
            <div class = "user-buttons">
                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="viewbooks">
                    <button type="submit" id="button-hover" class="user-buttons-catalog">Просмотр каталога книг</button>
                </form>

                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="userviewcommand">
                    <button type="submit" id="button-hover" class="user-buttons-users">Просмотр пользователей</button>
                </form>

                <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
            </div>
        </c:when>
        <c:when test="${sessionScope.userRole eq 'MODERATOR'}">
            <!-- Код для пользователя с ролью 'user' -->
        </c:when>
        <c:otherwise>
            <!-- Код для других пользователей или обработка ошибки -->
        </c:otherwise>
    </c:choose>

</body>
</html>
