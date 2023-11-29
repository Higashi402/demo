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
      <input type="hidden" name="command" value="redirecttousercatalog">
      <button id="button-hover" class="close-button"></button>
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
        <c:forEach var="requestEntry" items="${requestDictionary}">
          <tr>
            <td>${requestEntry.key}</td>
            <td>${requestEntry.value.bookAuthor}</td>
            <td>${requestEntry.value.bookTitle}</td>
            <td>${requestEntry.value.requestStatus}</td>
          </tr>
        </c:forEach>
        </c:otherwise>
        </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>