<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление пользователя</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>
    <%@include file="usercatalog.jsp"%>

    <h2>Добавление пользователя</h2>
    <div class = adminAddUserForm>
        <form action="controller" method="GET">
            <input type="hidden" name="command" value="viewusers">
            <button id="button-hover" class="close-button"></button>
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="adduser">
            <input type="hidden" id="username" name="username" value="">
            <input type="hidden" id="userFIO" name="userFIO" value="">
            <input type="hidden" id="userDOB" name="userDOB" value="">
            <input type="hidden" id="userPassword" name="userPassword" value="">

            <div class = "add-book-text-box">
                <label style="font-size: 25px; margin-bottom: 0px">Логин пользователя:</label>
                <input style="height: 15px" type="text" class = "adduser-name" id="name" name="name" required oninput="document.getElementById('username').value = this.value;">

                <label style="font-size: 25px;">ФИО пользователя:</label>
                <input style="height: 15px" type="text" class = "fio" id="fio" name="fio" required oninput="document.getElementById('userFIO').value = this.value;">

                <label style="font-size: 25px;">Пароль пользователя:</label>
                <input style="height: 15px" type="password" class = "password" id="password" name="password" required oninput="document.getElementById('userPassword').value = this.value;">

                <label for="role" style="font-size: 25px;">Роль пользователя:</label>
                <select style="height: 30px; font-size: 20px" id="role" name="userRole" >
                    <option value="ADMIN" >Администратор</option>
                    <option value="MODERATOR">Модератор</option>
                    <option value="LIBRARIAN">Библиотекарь</option>
                    <option value="USER">Пользователь</option>
                </select>

                <label style="font-size: 25px">Дата рождения пользователя:</label>
                <input style="height: 30px; font-size: 15px" type="date" id="birthdate" name="birthdate" required>

                <script>
                    document.getElementById('birthdate').addEventListener('change', function() {
                    var selectedDate = this.value;
                    var formattedDate = new Date(selectedDate).toISOString().split('T')[0];
                    document.getElementById('userDOB').value = formattedDate;
                    });
                </script>
                <input type="submit" class = "admin-add-user-button" id = "button-hover"  value="Добавить пользователя">
             <p style="color: red;">${userexistsmessage}</p>
                <p style="font-size: 35px">${resMessage}</p>
            </div>



        </form>
    </div>
</body>
</html>