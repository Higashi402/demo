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

        <p style="font-size: 40px">Ваши заявки</p>

        <form action="controller" method="POST">
            <input type="hidden" name="command" value="redirecttomainmenu">
            <button id="button-hover" class="close-button"></button>
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
                    <th>Статус</th>
                </tr>
                </thead>
                <c:forEach var="proposal" items="${proposals}">
                    <tr>
                        <td>${proposal.id}</td>
                        <td>${proposal.bookTitle}</td>
                        <td>${proposal.author}</td>
                        <td>${proposal.proposalStatus}</td>
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