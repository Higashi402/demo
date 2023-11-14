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
      <thead>
        <tr>
          <th>Название книги</th>
          <th>Автор книги</th>
          <th>Рейтинг</th>
        </tr>
      </thead>
      <tbody id="bookTableBody">
        <c:forEach var="bookEntry" items="${bookDictionary}">
          <tr>
            <td>${bookEntry.value.title}</td>
            <td>${bookEntry.value.author}</td>
            <td>${bookEntry.value.rating}</td>
          </tr>
        </c:forEach>
      </tbody>
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

<div id="newForm">
  <h2>Данные книги</h2>
  <!-- Добавьте элементы для отображения данных -->

  <!-- Заглушка для кнопки закрытия, будет заменена при открытии формы -->
  <div id="closeButtonPlaceholder"></div>

  <!-- Кнопка закрытия формы -->
  <button onclick="closeForm('newForm')">Закрыть</button>
</div>

<script>
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

  document.addEventListener('DOMContentLoaded', function () {
    var tableRows = document.querySelectorAll('#bookTableBody tr');
    tableRows.forEach(function (row) {
      row.addEventListener('mouseover', function () {
        this.classList.add('hover');
      });

      row.addEventListener('mouseout', function () {
        this.classList.remove('hover');
      });

      row.addEventListener('click', function () {
        openNewFormWithData(row.cells[0].innerText, row.cells[1].innerText, row.cells[2].innerText);
      });
    });
  });

  function openNewFormWithData(bookTitle, bookAuthor, bookRating) {
    var newForm = document.getElementById('newForm');
    newForm.style.display = 'block';

    var formContent = '<h2>Данные книги</h2>' +
            '<p><strong>Название:</strong> ' + bookTitle + '</p>' +
            '<p><strong>Автор:</strong> ' + bookAuthor + '</p>' +
            '<p><strong>Рейтинг:</strong> ' + bookRating + '</p>';

    newForm.innerHTML = formContent;

    var closeButton = document.createElement('div');
    closeButton.className = 'close-button';
    closeButton.onclick = function() { closeForm('newForm'); };
    newForm.appendChild(closeButton);
  }

  /*function submitRequest() {
    var tableBody = document.getElementById('bookTableBody');
    var selectedRow = tableBody.querySelector('tr.selected');

    if (selectedRow) {
      var bookTitle = selectedRow.cells[0].innerText;
      var bookAuthor = selectedRow.cells[1].innerText;
      var bookRating = selectedRow.cells[2].innerText;

      // Передаем данные в функцию для открытия формы с данными
      openNewFormWithData(bookTitle, bookAuthor, bookRating);
    } else {
      alert('Выберите книгу в таблице перед оформлением заявки.');
    }
  }*/

  window.addEventListener('load', restoreFormState);

</script>
</body>
</html>