<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="black-line-container">
    <hr class="user-black-line">
    <div class="user-centered-text">E-Book</div>
</div>
    <c:choose>
        <c:when test="${sessionScope.userRole eq 'USER'}">
            <div class = "user-buttons">
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="viewbooks">
                    <button type="submit" id="button-hover" class="user-buttons-catalog">Просмотр каталога книг</button>
                </form>

                <form action="controller" method="get">
                    <input type="hidden" name="command" value="bookrequestviewcommand">
                    <button type="submit" id="button-hover" class="user-buttons-request">Просмотр заявок</button>
                </form>

                <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
            </div>
        </c:when>
        <c:when test="${sessionScope.userRole eq 'ADMIN'}">
            <div class = "user-buttons">
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="viewbooks">
                    <button type="submit" id="button-hover" class="user-buttons-catalog">Просмотр каталога книг</button>
                </form>

                <form action="controller" method="get">
                    <input type="hidden" name="command" value="bookrequestviewcommand">
                    <button type="submit" id="button-hover" class="user-buttons-request">Просмотр заявок</button>
                </form>

                <form action="controller" method="get">
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
