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
    <c:when test="${not empty sessionScope.user}">
        <c:set var="user" value="${sessionScope.user}" />
        <c:choose>
            <c:when test="${user.roleName == 'USER'}">
                <div class = "header-buttons">
                    <form action="/demo/controller" method="GET">
                        <input type="hidden" name="command" value="viewbooks">
                        <button type="submit" id="button-hover" class="user-buttons-catalog">Просмотр каталога книг</button>
                    </form>

                    <form action="/demo/controller" method="GET">
                        <input type="hidden" name="command" value="viewrequests">
                        <button type="submit" id="button-hover" class="user-buttons-request">Просмотр заявок</button>
                    </form>
                </div>
                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="logout">
                    <button type="submit" id="button-hover" class="user-buttons-exit"></button>
                </form>
            </c:when>
            <c:when test="${user.roleName == 'ADMIN'}">
                <div class = "header-buttons">
                    <form action="/demo/controller" method="GET">
                        <input type="hidden" name="command" value="viewbooks">
                        <button type="submit" id="button-hover" class="user-buttons-catalog">Просмотр каталога книг</button>
                    </form>

                    <form action="/demo/controller" method="GET">
                        <input type="hidden" name="command" value="viewusers">
                        <button type="submit" id="button-hover" class="user-buttons-users">Просмотр пользователей</button>
                    </form>
                </div>
                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="logout">
                    <button type="submit" id="button-hover" class="user-buttons-exit"></button>
                </form>
            </c:when>
            <c:when test="${user.roleName == 'MODERATOR'}">
                <div class = "header-buttons">
                    <form action="/demo/controller" method="GET">
                        <input type="hidden" name="command" value="viewusers">
                        <button type="submit" id="button-hover" class="user-buttons-users">Просмотр пользователей</button>
                    </form>
                </div>
                <form action="/demo/controller" method="GET">
                    <input type="hidden" name="command" value="logout">
                    <button type="submit" id="button-hover" class="user-buttons-exit"></button>
                </form>
            </c:when>
        </c:choose>
    </c:when>
    <c:otherwise>
        <!-- Код для других пользователей или обработка ошибки -->
    </c:otherwise>
</c:choose>

</body>
</html>
