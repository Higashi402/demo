<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Панель пользователя</title>
</head>
<body>
<h1>Панель пользователя</h1>

<h2>Выставить оценку книге</h2>
<form action="rateBook.jsp" method="post">
  ID книги: <input type="text" name="bookId"><br>
  Оценка (1-5): <input type="number" name="rating" min="1" max="5"><br>
  <input type="submit" value="Выставить оценку">
</form>

<h2>Оставить заявку на получение книги</h2>
<form action="requestBook.jsp" method="post">
  ID книги: <input type="text" name="bookId"><br>
  <input type="submit" value="Добавить заявку на получение книги">
</form>

<h2>Просмотр каталога книг</h2>
<form action="viewBooks.jsp" method="get">
  <input type="submit" value="Показать каталог книг">
</form>
</body>
</html>