<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User</title>
  <style>
    <%@include file='/css/style.css' %>
  </style>
</head>
<body>

<div class="black-line-container">
  <hr class="user-black-line">
  <div class="user-centered-text">E-Book</div>
</div>

<div class = "user-button-catalog">

</div>

<div class = "user-buttons">
    <button id="button-hover"  onclick="openForm('viewBooksForm')" class="user-buttons-catalog">Просмотр каталога книг</button>
    <button id="button-hover" onclick="openForm('requestBookForm')" class = "user-buttons-request">Просмотр заявок</button>
    <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
</div>

<div id="viewBooksForm" class="modal">
  <div class="modal-content-catalog" id="viewBooksContent">
    <div class="close-button" id ="button-hover" onclick="closeForm('viewBooksForm')"></div>
    <h2>Просмотр каталога книг</h2>
    <form action="viewBooks.jsp" method="get">
      <input class = "user-button-submit" id="button-hover" type="submit" value="Показать каталог книг">
    </form>
  </div>
</div>

<div id="requestBookForm" class="modal">
  <div class="modal-content-request" id="requestBookContent">
    <div class="close-button" id="button-hover" onclick="closeForm('requestBookForm')"></div>
    <h2>Просмотр заявок</h2>
    <form action="viewBooks" method="get">
      <input class = "user-button-submit" id="button-hover" type="submit" value="Показать список заявок">
    </form>
  </div>
</div>

<div id="confirmExitForm" class="modal">
  <div class="modal-content-exit" id="confirmExitContent">
    <div class="close-button" id="button-hover" onclick="closeForm('confirmExitForm')"></div>
    <div class = "exitForm-label-acception">
      Подтверждение выхода
    </div>
    <div class = "exitForm-label-quetion">
      Вы точно хотите выйти?
    </div>
    <form action="controller" method="post">
      <div class="button-container">
        <button class = "user-button-submit" id="button-hover"  type="submit">Да</button>
        <button class = "user-button-submit" id="button-hover"  type="button" onclick="closeForm('confirmExitForm')">Нет</button>
      </div>
      <input type="hidden" name="command" value="logout">
    </form>
  </div>
</div>

<script>
  function openForm(formId) {
    var modals = document.querySelectorAll(".modal");
    for (var i = 0; i < modals.length; i++) {
      modals[i].style.display = "none";
    }

    var form = document.getElementById(formId);
    form.style.display = "block";
  }

  function closeForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = "none";

    function exit() {
      closeForm('confirmExitForm');
    }
  }
</script>
</body>
</html>