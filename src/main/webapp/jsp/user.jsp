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
  <form action="controller" method="get">
    <input type="hidden" name="command" value="viewbooks">
    <button type="submit" id="button-hover" onclick="openForm('viewBooksForm')" class="user-buttons-catalog">Просмотр каталога книг</button>
  </form>
  <button id="button-hover" onclick="openForm('requestBookForm')" class = "user-buttons-request">Просмотр заявок</button>
  <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
</div>

<div id="viewBooksForm" class="modal" style="display: none;">
  <div class="modal-content-catalog" id="viewBooksContent">
    <div class="close-button" id="button-hover" onclick="closeForm('viewBooksForm')"></div>
    <table>
      <tr>
        <th>Название книги</th>
        <th>Автор книги</th>
      </tr>
      <c:forEach var="bookEntry" items="${bookDictionary}">
        <tr>
          <td>${bookEntry.value.title}</td>
          <td>${bookEntry.value.author}</td>
        </tr>
      </c:forEach>
    </table>
  </div>

</div>


<div id="requestBookForm" class="modal"  style="display: none;">
  <div class="modal-content-request" id="requestBookContent">
    <div class="close-button" id="button-hover" onclick="closeForm('requestBookForm')"></div>
    <h2>Просмотр заявок</h2>
    <form action="viewBooks" method="get">
      <input class = "user-button-submit" id="button-hover" type="submit" value="Показать список заявок">
    </form>
  </div>
</div>

<div id="confirmExitForm" class="modal" style="display: none;">
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
  // Функция для сохранения состояния формы в localStorage
  // Функция для сохранения состояния формы в localStorage
  function saveFormState(formId, isOpen) {
    // Сохраняем состояние формы в localStorage
    localStorage.setItem(formId, isOpen ? "1" : "0");
  }

  // Функция для открытия формы
  function openForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = "block";

    // Сохраняем состояние формы как открытой
    saveFormState(formId, true);
  }

  // Функция для закрытия формы
  function closeForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = "none";

    // Сохраняем состояние формы как закрытой
    saveFormState(formId, false);
  }

  // Функция для восстановления состояния форм после обновления страницы
  function restoreFormState() {
    // Проходим по всем ключам в localStorage
    for (var i = 0; i < localStorage.length; i++) {
      var formId = localStorage.key(i);
      var isOpen = localStorage.getItem(formId);

      if (isOpen === "1") {
        openForm(formId); // Открываем формы, для которых состояние - 1 (открыто)
      }
    }
  }

  // Восстанавливаем состояние после загрузки страницы
  window.addEventListener('load', restoreFormState);

</script>
</body>
</html>