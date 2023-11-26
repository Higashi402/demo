
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>


<div class="black-line-container">
    <hr class="user-black-line">
    <div class="user-centered-text">E-Book</div>
</div>

<div class = "user-button-catalog">
    <div></div>
</div>

<div class = "user-buttons">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="viewbooksniversal">
        <button type="submit" id="button-hover"  class="user-buttons-catalog">Просмотр каталога книг</button>
    </form>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="bookrequestviewcommand">
        <button type="submit" id="button-hover" onclick="openForm('requestsForm')" class="user-buttons-request">Просмотр заявок</button>
    </form>
    <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
</div>


<%--<body>

<h2>Создание пользователя</h2>
<form action="createUser" method="post">
    Имя пользователя: <input type="text" name="username"><br>
    Пароль: <input type="password" name="password"><br>
    <input type="submit" value="Создать пользователя">
</form>

<h2>Удаление пользователя</h2>
<form action="deleteUser" method="post">
    Имя пользователя: <input type="text" name="username"><br>
    <input type="submit" value="Удалить пользователя">
</form>

<h2>Просмотр списка пользователей</h2>
<form action="controller" method="get">
    <input type="hidden" name="command" value="viewusers">
    <input type="submit" value="Показать список пользователей">
</form>

<table>
    <tr>
        <th>Имя пользователя</th>
        <th>Роль</th>
    </tr>
    <c:forEach var="userEntry" items="${userDictionary}">
        <tr>
            <td>${userEntry.getKey()}</td>
            <td>${userEntry.getValue()}</td>
        </tr>
    </c:forEach>
</table>


<h2>Просмотр каталога книг</h2>
<form action="viewBooks" method="get">
    <input type="submit" value="Показать каталог книг">
</form>

<h2>Просмотр заявок на получение книг</h2>
<form action="viewBookRequest" method="get">

    <input type="submit" value="Показать заявки на получение книг">
</form>

<h2>Добавление книги в библиотеку</h2>
<form action="addBook" method="post">
    Название книги: <input type="text" name="bookTitle"><br>
    Автор: <input type="text" name="author"><br>
    <input type="submit" value="Добавить книгу">
</form>

<h2>Удаление заявки на получение книги</h2>
<form action="deleteBookRequest" method="post">
    ID заявки: <input type="text" name="requestId"><br>
    <input type="submit" value="Удалить заявку">
</form>

<h2>Снятие книги с выдачи читателю</h2>
<form action="returnBook" method="post">
    ID книги: <input type="text" name="bookId"><br>
    <input type="submit" value="Снять книгу с выдачи">
</form>

<h2>Редактирование информации о пользователях</h2>
<form action="editUser" method="post">
    Имя пользователя: <input type="text" name="username"><br>
    Новое имя: <input type="text" name="newUsername"><br>
    Новый пароль: <input type="password" name="newPassword"><br>
    <input type="submit" value="Редактировать пользователя">
</form>--%>

<script>

    function saveFormState(formId, isOpen) {
        localStorage.setItem(formId, isOpen ? "1" : "0");
    }

    // Функция для открытия формы
    function openForm(formId) {

        var form = document.getElementById(formId);
        form.style.display = "block";
        saveFormState(formId, true);
    }

    // Функция для закрытия формы
    function closeForm(formId) {
        var form = document.getElementById(formId);
        form.style.display = "none";
        saveFormState(formId, false);
    }

    // Функция для восстановления состояния форм после обновления страницы
    function restoreFormState() {
        for (var i = 0; i < localStorage.length; i++) {
            var formId = localStorage.key(i);
            var isOpen = localStorage.getItem(formId);

            if (isOpen === "1") {
                openForm(formId);
            }
        }
    }









    window.addEventListener('load', restoreFormState);

</script>
</body>
</html>
