
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
  <button id="button-hover" onclick="showRequestsForm()" class = "user-buttons-request">Просмотр заявок</button>
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
      <table>
        <thead>
        <tr>
          <th>Номер заявки</th>
          <th>Клиент</th>
          <th>Статус</th>
        </tr>
        </thead>
        <tbody id="requestsTableBody">
        <!-- Здесь будут строки таблицы с заявками -->
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
  function showRequestsForm() {
    // Ваш код для загрузки данных заявок в таблицу. Например, через AJAX-запрос.
    // Временные данные для примера
    var requestData = [
      { id: 1, client: 'Иванов', status: 'В обработке' },
      { id: 2, client: 'Петров', status: 'Завершена' },
      { id: 3, client: 'Иванов', status: 'В обработке' },
      { id: 4, client: 'Петров', status: 'Завершена' },
      { id: 5, client: 'Иванов', status: 'В обработке' },
      { id: 6, client: 'Петров', status: 'Завершена' },
      { id: 7, client: 'Иванов', status: 'В обработке' },
      { id: 8, client: 'Петров', status: 'Завершена' },
      { id: 9, client: 'Иванов', status: 'В обработке' },
      { id: 10, client: 'Петров', status: 'Завершена' },
      { id: 11, client: 'Иванов', status: 'В обработке' },
      { id: 12, client: 'Петров', status: 'Завершена' },
      { id: 13, client: 'Иванов', status: 'В обработке' },
      { id: 14, client: 'Петров', status: 'Завершена' },
      { id: 15, client: 'Иванов', status: 'В обработке' },
      { id: 16, client: 'Петров', status: 'Завершена' },
      { id: 17, client: 'Петров', status: 'Завершена' },
      { id: 18, client: 'Иванов', status: 'В обработке' },
      { id: 20, client: 'Петров', status: 'Завершена' },
      { id: 21, client: 'Иванов', status: 'В обработке' },
      { id: 22, client: 'Петров', status: 'Завершена' },
      { id: 23, client: 'Иванов', status: 'В обработке' },
      { id: 24, client: 'Петров', status: 'Завершена' },
      { id: 25, client: 'Петров', status: 'Завершена' },
      { id: 26, client: 'Иванов', status: 'В обработке' },
      { id: 27, client: 'Петров', status: 'Завершена' },
      { id: 28, client: 'Иванов', status: 'В обработке' },
      { id: 29, client: 'Петров', status: 'Завершена' },
      { id: 30, client: 'Иванов', status: 'В обработке' },
      { id: 31, client: 'Петров', status: 'Завершена' },
    ];

    // Очищаем предыдущие данные в таблице
    document.getElementById('requestsTableBody').innerHTML = '';

    // Заполняем таблицу данными заявок
    requestData.forEach(function (request) {
      var row = document.createElement('tr');
      row.innerHTML = '<td>' + request.id + '</td>' +
              '<td>' + request.client + '</td>' +
              '<td>' + request.status + '</td>';
      document.getElementById('requestsTableBody').appendChild(row);
    });

    // Отображаем форму с заявками
    document.getElementById('requestsForm').style.display = 'block';
  }


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