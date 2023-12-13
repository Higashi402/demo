<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
  <title>Информация о пользователе</title>
  <meta charset="UTF-8">
  <style>
  <%@include file='/css/style.css' %>
  </style>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>

<body>

<%@include file="usercatalog.jsp" %>

<div class="bookInfoForm">
  <form action="controller" method="GET">
    <input type="hidden" name="command" value="viewusers">
    <button id="button-hover" class="close-button"></button>
  </form>
  <div class="content"> <p style="font-size: 30px">
    <strong>Логин пользователя:</strong> ${requesteduser.username}</p>
    <p style="font-size: 30px"><strong>Роль:</strong> ${requesteduser.roleName}</p>
    <p style="font-size: 30px"> <strong> Ф.И.О:</strong> ${requesteduser.userFIO}</p>
    <p style="font-size: 30px"> <strong> Дата рождения:</strong> ${requesteduser.userDOB}</p>
    <p style="font-size: 30px">
    <strong>
      Статус блокировки:
      <c:choose>
        <c:when test="${requesteduser.blocked == 1}">
          Заблокирован
        </c:when>
        <c:otherwise>
          Разблокирован
        </c:otherwise>
      </c:choose>
    </strong>
    </p>
    <div class="admin-user-info"> <c:set var="user" value="${sessionScope.user}" /> <c:choose>
      <c:when test="${user.roleName == 'ADMIN'}">
      <form action="controller" method="GET">
        <input type="hidden" name="command" value="viewuserrequests">
        <input type="hidden" name="username" value="${requesteduser.username}">
        <button type="submit" id="button-hover" class="user-button-submit">Посмотреть заявки пользователя</button>
      </form> <form action="controller" method="POST">
      <input type="hidden" name="command" value="userdelete">
      <input type="hidden" name="id" value="${requesteduser.id}">
      <button type="submit" id="button-hover" class="user-button-submit">Удалить пользователя</button>
      </form>
        <form action="controller" method="POST">
          <input type="hidden" name="command" value="redirecttoedituser">
          <input type="hidden" name="id" value="${requesteduser.id}">
          <button type="submit" id="button-hover" class="user-button-submit">Редактировать пользователя</button>
        </form>
      </c:when>
      <c:when test="${user.roleName == 'MODERATOR'}">

      <form action="controller" method="POST">
        <input type="hidden" name="command" value="blockunblockuser">
        <input type="hidden" name="id" value="${requesteduser.id}">
        <input type="submit" id="button-hover" class="user-button-submit" value="Изменить статус блокировки">
      </form>
      </c:when>
    </c:choose>
    </div>

  <c:if test="${not empty errorMessage}"><p style="color: red;">${errorMessage}</p>
  </c:if>
  <c:if test="${not empty errorDeleteMessage}"> <p style="color: red;">${errorDeleteMessage}</p>
  </c:if>
  </div>
</div>
</body>
</html>