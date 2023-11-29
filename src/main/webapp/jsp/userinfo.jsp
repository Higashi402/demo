<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
    <title>Информация о пользователе</title>
    <meta charset="UTF-8">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .content {
            text-align: center;
        }
        /* Other styles */
        /* You can include your other CSS styles here */
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<form action="controller" method="GET">
    <input type="hidden" name="command" value="redirectToUserCatalog">
    <button id="button-hover" class="close-button"></button>
</form>

<div class="content">
    <p><strong>Имя пользователя:</strong> ${username}</p>
    <p><strong>Роль:</strong> ${userRole}</p>
    <div>
        <form action="controller" method="GET">
            <input type="hidden" name="command" value="viewuserrequests">
            <input type="hidden" name="username" value="${username}">
            <button type="submit" style="background-color: #f0f0f0; /* Add your styles */">Посмотреть заявки пользователя</button>
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="deleteuser">
            <input type="hidden" name="id" value="${username}">
            <button type="submit" style="background-color: #f0f0f0; /* Add your styles */">Удалить пользователя</button>
        </form>
    </div>

    <!-- Проверяем наличие атрибута errorMessage и выводим его -->
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
</div>

</body>
</html>