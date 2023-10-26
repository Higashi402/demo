<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Панель администратора</title>
</head>
<body>
<h1>Панель администратора</h1>

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
<form action="viewUsers" method="get">
    <input type="submit" value="Показать список пользователей">
</form>

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
</form>
</body>
</html>
