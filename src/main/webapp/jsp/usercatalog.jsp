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

        <form id="user-request-form" action="controller" method="POST" accept-charset="UTF-8" style="display: none;">
            <input type="hidden" name="command" value="viewuserinformation">
            <input type="hidden" name="name" id="Username">
            <input type="hidden" name="role" id="UserRole">
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
                <c:forEach var="userEntry" items="${userDictionary}">
                    <tr class='book-row' onclick="submitUserForm(this)"  data-user="${userEntry.value.username}" data-role="${userEntry.value.role}">
                        <td>${userEntry.value.username}</td>
                        <td>${userEntry.value.role}</td>
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