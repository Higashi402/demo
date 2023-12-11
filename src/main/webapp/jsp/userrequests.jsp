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

    <p style="font-size: 40px">Заявки пользователя ${requestedUser.username}</p>

    <form action="controller" method="GET">
      <input type="hidden" name="command" value="viewuserinformation">
      <input type="hidden" name="name" value="${requestedUser.username}">
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
        <c:when test="${empty proposals}">
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
        <c:forEach var="proposal" items="${proposals}">
          <tr class='book-row' onclick="submitUserRequest(this)" data-user="${user.username}" data-id="${proposal.id}" >
          <td>${proposal.id}</td>
          <td>${proposal.bookTitle}</td>
          <td>${proposal.author}</td>
          <td>${proposal.proposalStatus}</td>
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
