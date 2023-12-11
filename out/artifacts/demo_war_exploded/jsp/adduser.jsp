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
    <%@include file="header.jsp" %>
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
    <label for="title" style="font-size: 25px; margin-bottom: 20px">Логин пользователя:</label>
    <input type="text" id="name" name="name" required oninput="document.getElementById('username').value = this.value;">

    <label for="" style="font-size: 25px; margin-bottom: 20px">ФИО пользователя:</label>
    <input type="text" id="fio" name="fio" required oninput="document.getElementById('userFIO').value = this.value;">

    <label for="password" style="font-size: 25px; margin-right: 20px">Пароль пользователя:</label>
    <input type="password" id="password" name="password" required oninput="document.getElementById('userPassword').value = this.value;">

      <label for="role" style="font-size: 25px; margin-right: 20px">Роль пользователя:</label>
      <select id="role" name="userRole" >
          <option value="ADMIN" >Администратор</option>
        <option value="MODERATOR">Модератор</option>
        <option value="LIBRARIAN">Библиотекарь</option>
        <option value="USER">Пользователь</option>
      </select>

      <label for="" style="font-size: 25px; margin-bottom: 20px">Дата рождения пользователя:</label>
      <input type="date" id="birthdate" name="birthdate" required>

      <script>
        document.getElementById('birthdate').addEventListener('change', function() {
        var selectedDate = this.value;
        var formattedDate = new Date(selectedDate).toISOString().split('T')[0];
        document.getElementById('userDOB').value = formattedDate;
        });
      </script>
    </div>

    <input type="submit" class = "admin-add-book" id = "button-hover" value="Добавить пользователя">
    </form>
    </div>
    </body>
    </html>