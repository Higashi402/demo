<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Пользователь</title>
  <style>
    <%@include file='/css/style.css' %>
    body {
        background-image: url('/img/background.jpg');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        background-attachment: fixed;
    }
  </style>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>

<%@include file="header.jsp" %>

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

    <h2 style="text-align: center; font-size: 40px;">Ваши заявки</h2>

    <div id="requestsTableContainer">
      <table id = "requestTable">

        <tbody id="requestTableBody">
        <c:choose>
          <c:when test="${empty requestDictionary}">
            <p>Заявок нет</p>
          </c:when>
          <c:otherwise>
        <thead>
        <tr>
          <th>Номер заявки</th>
          <th>Автор</th>
          <th>Название книги</th>
        </tr>
        </thead>
            <c:forEach var="requestEntry" items="${requestDictionary}">
              <tr>
                <td>${requestEntry.key}</td>
                <td>${requestEntry.value.bookAuthor}</td>
                <td>${requestEntry.value.bookTitle}</td>
              </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
        </tbody>
      </table>
    </div>

  </div>
</div>

<div id="newForm">
  <c:choose>
    <c:when test="${empty resMessage}">
      <h2>Данные книги</h2>
    </c:when>
    <c:otherwise>
      <h2>Заявка</h2>
      <p><strong>Статус:</strong> ${resMessage}</p>
      <!-- Здесь можете добавить другие атрибуты книги, если они также будут отправляться -->
    </c:otherwise>
  </c:choose>

  <div id="closeButtonPlaceholder"></div>

  <div id="sendRequestButtonPlaceholder"></div>

  <button onclick="closeForm('newForm')">Закрыть</button>
</div>
</body>
</html>