<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список пользователей</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="viewUsersForm">
    <div class="modal-content-catalog">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="redirecttomainmenu">
            <button id="button-hover" class="close-button"></button>
        </form>

    <c:set var="user" value="${sessionScope.user}" />
    <c:choose>
        <c:when test="${user.roleName == 'ADMIN'}">
            <div class = "catalog-header" >
            <p style="font-size: 40px; margin-top: 5px">Список пользователей</p>
            <form action="controller" method="post">
            <input type="hidden" name="command" value="redirecttoadduserpage">
            <button type="submit" id="button-hover" class = "user-button-submit">Добавить пользователя</button>
            </form>
            </div>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>

        <form id="user-request-form" action="controller" method="GET" accept-charset="UTF-8" style="display: none;">
            <input type="hidden" name="command" value="viewuserinformation">
            <input type="hidden" name="userId" id="userId">
            <input type="submit" id="submitBtn" style="display: none;">
        </form>

        <p style="font-size: 40px">Список пользователей</p>
        <div class="userContainer">
            <table style="width: 750px; font-size: 20px; ">
                <thead>
                <tr style="font-size: 30px;">
                    <th style="width: 200px;">Имя пользователя</th>
                    <th style="width: 200px;">Роль</th>
                </tr>
                </thead>
                <tbody class="tableBody">
                <c:forEach var="userEntry" items="${users}">
                    <tr class='book-row' onclick="submitUserForm(this);"  user-id="${userEntry.id}">
                        <td>${userEntry.username}</td>
                        <td>${userEntry.roleName}</td>
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