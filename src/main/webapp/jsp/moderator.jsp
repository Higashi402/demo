<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Панель модератора</title>
</head>
<body>
<h1>Панель модератора</h1>

<h2>Блокировка пользователя</h2>
<form action="blockUser" method="post">
  Имя пользователя: <input type="text" name="username"><br>
  <input type="submit" value="Заблокировать пользователя">
</form>

<h2>Разблокировка пользователя</h2>
<form action="unblockUser" method="post">
  Имя пользователя: <input type="text" name="username"><br>
  <input type="submit" value="Разблокировать пользователя">
</form>

<h2>Регистрация пользователя</h2>
<form action="registerUser" method="post">
  Имя пользователя: <input type="text" name="username"><br>
  Пароль: <input type="password" name="password"><br>
  <input type="submit" value="Зарегистрировать пользователя">
</form>

<h2>Просмотр списка пользователей</h2>
<form action="viewUsers" method="get">
  <input type="submit" value="Показать список пользователей">
</form>
</body>
</html>