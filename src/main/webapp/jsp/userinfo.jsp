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
<%@include file="header.jsp" %>
<%@include file="usercatalog.jsp" %>

<div class = "bookInfoForm">
  <form action="controller" method="POST">
    <input type="hidden" name="command" value="redirecttousercatalog">
    <button id="button-hover" class="close-button"></button>
  </form>

  <div class="content">
    <p style="font-size: 30px"><strong>Имя пользователя:</strong> ${username}</p>
    <p style="font-size: 30px"><strong>Роль:</strong> ${userRole}</p>
    <div class ="admin-user-info">
      <form action="controller" method="GET">
        <input type="hidden" name="command" value="viewuserrequests">
        <input type="hidden" name="username" value="${username}">
        <button type="submit" id = "button-hover" class = "user-button-submit">Посмотреть заявки пользователя</button>
      </form>
      <form action="controller" method="GET">
        <input type="hidden" name="command" value="userdelete">
        <input type="hidden" name="username" value="${username}">
        <button type="submit" id = "button-hover" class = "user-button-submit">Удалить пользователя</button>
      </form>
    </div>

    <!-- Проверяем наличие атрибута errorMessage и выводим его -->
    <c:if test="${not empty errorMessage}">
      <p style="color: red;">${errorMessage}</p>
    </c:if>

    <c:if test="${not empty errorDeleteMessage}">
      <p style="color: red;">${errorDeleteMessage}</p>
    </c:if>
  </div>
</div>

</body>
</html>
