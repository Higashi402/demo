<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редактирование пользователя</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>
<%@include file="userinfo.jsp"%>

<h2>Редактирование пользователя</h2>
<div class = adminAddUserForm>
    <form action="controller" method="GET">
        <input type="hidden" name="command" value="viewusers">
        <button id="button-hover" class="close-button"></button>
    </form>
    <form action="controller" method="POST">
        <input type="hidden" name="command" value="edituser">
        <input type="hidden" name="id" value="${requesteduser.id}">
        <input type="hidden" id="username" name="username" value="">
        <input type="hidden" id="userFIO" name="userFIO" value="">
        <input type="hidden" id="userDOB" name="userDOB" value="">
        <input type="hidden" id="userPassword" name="userPassword" value="">

        <div class="add-book-text-box">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="edituser">
                <input type="hidden" id="username" name="username" value="">
                <input type="hidden" id="userFIO" name="userFIO" value="">
                <input type="hidden" id="userDOB" name="userDOB" value="">
                <input type="hidden" id="userPassword" name="userPassword" value="">

                <label for="title" style="font-size: 25px; margin-bottom: 20px">Логин пользователя:</label>
                <input type="text" id="name" name="name" value="${empty requesteduser ? '' : requesteduser.username}" required>

                <label for="" style="font-size: 25px; margin-bottom: 20px">ФИО пользователя:</label>
                <input type="text" id="fio" name="fio" value="${empty requesteduser ? '' : requesteduser.userFIO}" required>

                <label for="password" style="font-size: 25px; margin-right: 20px">Пароль пользователя:</label>
                <input type="text" id="password" name="password" value="${empty requesteduser ? '' : requesteduser.password}" required>

                <label for="role" style="font-size: 25px; margin-right: 20px">Роль пользователя:</label>
                <select id="role" name="userRole">
                    <c:set var="selectedRole" value="${empty requesteduser ? '' : requesteduser.roleName}" />
                    <option value="ADMIN" ${selectedRole eq 'ADMIN' ? 'selected' : ''}>Администратор</option>
                    <option value="MODERATOR" ${selectedRole eq 'MODERATOR' ? 'selected' : ''}>Модератор</option>
                    <option value="LIBRARIAN" ${selectedRole eq 'LIBRARIAN' ? 'selected' : ''}>Библиотекарь</option>
                    <option value="USER" ${selectedRole eq 'USER' ? 'selected' : ''}>Пользователь</option>
                </select>

                <label for="" style="font-size: 25px; margin-bottom: 20px">Дата рождения пользователя:</label>
                <input type="date" id="birthdate" name="birthdate" value="${empty requesteduser ? '' : requesteduser.userDOB}" required>

                <input type="submit" class="user-button-submit" style="display: flow; position: relative; left: 10%" id="button-hover" value="Изменить" onclick="checkChanges()">
                <p style="color: red;">${userexistsmessage}</p>
                <p style="font-size: 35px">${resMessage}</p>
                <span id="changeStatus" style="color: red; display: none;">Нет изменений для сохранения.</span>
            </form>
        </div>
    </form>
</div>
</body>
</html>