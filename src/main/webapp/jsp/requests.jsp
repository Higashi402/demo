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

<div id="requestsForm" class="modal common-form-style">
    <div class="modal-content-catalog" style="display: flex; flex-direction: column; align-items: center;">

        <form action="controller" method="POST">
            <input type="hidden" name="command" value="close">
            <button id="button-hover" class="close-button"></button>
        </form>

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
</body>
</html>