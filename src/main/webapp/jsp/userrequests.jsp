<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Заявки</title>
  <style>
    <%@include file='/css/style.css' %>
  </style>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<%@include file="header.jsp" %>

<div class="requestsForm">
  <div class="modal-content-catalog">

    <p style="font-size: 40px">Заявки пользователя ${username}</p>

    <form action="controller" method="POST">
      <input type="hidden" name="command" value="redirecttomainmenu">
      <button id="button-hover" class="close-button"></button>
    </form>

    <form id="request-form" action="controller" method="POST" accept-charset="UTF-8" style="display: none;">
      <input type="hidden" name="command" value="viewuserrequestinformation">
      <input type="hidden" name="id" id="requestId">
      <input type="hidden" name="username" id="username">
      <input type="hidden" name="title" id="requestTitle">
      <input type="hidden" name="author" id="requestAuthor">
      <input type="hidden" name="status" id="requestStatus">

      <input type="submit" id="submitBtn" style="display: none;">
    </form>

    <div class="requestsTableContainer">
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
          <th>Статус заявки
        </tr>
        </thead>
        <tbody class="tableBody">
        <c:forEach var="requestEntry" items="${requestDictionary}">
          <tr class='book-row' onclick="submitUserRequest(this)" data-user="${username}" data-id="${requestEntry.key}" data-author="${requestEntry.value.bookAuthor}"
              data-title="${requestEntry.value.bookTitle}" data_status="${requestEntry.value.requestStatus}">
            <td>${requestEntry.key}</td>
            <td>${requestEntry.value.bookAuthor}</td>
            <td>${requestEntry.value.bookTitle}</td>
            <td>${requestEntry.value.requestStatus}</td>
          </tr>
        </c:forEach>
        </tbody>
        </c:otherwise>
        </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
