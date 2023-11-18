
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>

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

  <form action="controller" method="get">
    <input type="hidden" name="command" value="viewrequests">
    <button type="submit" id="button-hover" onclick="openForm('requestsForm')" class="user-buttons-request">Просмотр заявок</button>
  </form>
  <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
</div>

<div id="viewBooksForm" class="modal" style="display: none;">
  <div class="modal-content-catalog" id="viewBooksContent" style="display: flex; flex-direction: column; align-items: center; width: 100%;">
    <div class="close-button" id="button-hover" onclick="closeForm('viewBooksForm')"></div>

    <h2 style="text-align: center; font-size: 40px;">Каталог книг</h2>
    <div id="booksContainer">
      <table style="width: 700px;">
        <thead>
          <tr>
            <th>Название книги</th>
            <th style="width: 200px;">Автор книги</th>
            <th style="width: 200px;">Рейтинг</th>
          </tr>
        </thead>
        <tbody id="bookTableBody">
          <c:forEach var="bookEntry" items="${bookDictionary}">
            <tr>

              <td hidden>${bookEntry.key}</td>
              <td>${bookEntry.value.title}</td>
              <td>${bookEntry.value.author}</td>
              <td>${bookEntry.value.rating}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
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

<div id="requestsForm" class="modal common-form-style" style="display: none;">
  <div class="modal-content-catalog" style="display: flex; flex-direction: column; align-items: center;">
    <div class="close-button" onclick="closeForm('requestsForm')"></div>

    <!-- Добавленный элемент для текста "Ваши заявки" -->
    <h2 style="text-align: center; font-size: 40px;">Ваши заявки</h2>

    <!-- Контейнер для таблицы -->
    <div id="requestsTableContainer">
      <table id = "requestTable">
        <thead>
        <tr>
          <th>Номер заявки</th>
          <th>Автор</th>
          <th>Название книги</th>
        </tr>
        </thead>
        <tbody id="requestTableBody">
        <c:forEach var="requestEntry" items="${requestDictionary}">
          <tr>
            <td>${requestEntry.key}</td>
            <td>${requestEntry.value.bookAuthor}</td>
            <td>${requestEntry.value.bookTitle}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

  </div>
</div>

<div id="newForm">
  <h2>Данные книги</h2>

  <div id="closeButtonPlaceholder"></div>

  <div id="sendRequestButtonPlaceholder"></div>

  <button onclick="closeForm('newForm')">Закрыть</button>
</div>

<script>

  function saveFormState(formId, isOpen) {
    localStorage.setItem(formId, isOpen ? "1" : "0");
  }

  // Функция для открытия формы
  function openForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = "block";

    saveFormState(formId, true);
    if(formId == 'requestsForm') {
      var hasBookRequests = <%= request.getAttribute("hasBookRequests") %>;

      if (!hasBookRequests) {
        document.getElementById('requestsTableContainer').style.display = 'none';
        document.getElementById('requestTable').style.display = 'none';

      } else {

      }
    }
  }

  // Функция для закрытия формы
  function closeForm(formId) {
    var form = document.getElementById(formId);
    var form_main = document.getElementById('newForm');
    if (formId == 'viewBooksForm') {
      form.style.display = "none";
      form_main.style.display = "none";
    }
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
        var rowIndex = this.getAttribute('data-row-index'); // Получаем номер строки
        openNewFormWithData(row.cells[0].innerText, row.cells[1].innerText, row.cells[2].innerText, row.cells[3].innerText);
      });
    });
  });

  function openNewFormWithData(bookId, bookTitle, bookAuthor, bookRating) {
    var newForm = document.getElementById('newForm');
    newForm.style.display = 'block';

    var formContent = '<h2>Данные книги</h2>' +
            '<p><strong>ID:</strong> ' + bookId + '</p>' +
            '<p><strong>Название:</strong> ' + bookTitle + '</p>' +
            '<p><strong>Автор:</strong> ' + bookAuthor + '</p>' +
            '<p><strong>Рейтинг:</strong> ' + bookRating + '</p>';

    newForm.innerHTML = formContent;

    var sendRequestButtonPlaceholder = document.getElementById('sendRequestButtonPlaceholder');
    var sendRequestButton = document.createElement('button');
    sendRequestButton.textContent = 'Оставить заявку на книгу';
    sendRequestButton.addEventListener('click', function() {
      redirectToBookRequestForm(bookId); // Вызываем функцию для отправки запроса на сервер
    });
    newForm.appendChild(sendRequestButton);

    var closeButton = document.createElement('div');
    closeButton.className = 'close-button';
    closeButton.onclick = function() { closeForm('newForm'); };
    newForm.appendChild(closeButton);
  }


  function redirectToBookRequestForm(bookId) {



    const params = new URLSearchParams();
    params.append('command', 'bookrequestcommand');
    params.append('action', 'add');
    params.append('id', bookId);

    fetch('controller', {
      method: 'POST',
      body: params
    })
            .then(response => {
              console.log('Ответ от сервера', response);
            })
            .catch(error => {
              console.error('Ошибка:', error);
            });
  }

  window.addEventListener('load', restoreFormState);

</script>
</body>
</html>