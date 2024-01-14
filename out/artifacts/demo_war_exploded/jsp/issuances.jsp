<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Выдачи книг</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="viewBooksForm">
    <div class="modal-content-catalog">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="redirecttomainmenu">
            <button id="button-hover" class="close-button"></button>
        </form>
        <div class = "catalog-header" >
            <p style="font-size: 40px; margin-top: 5px">Выдачи книг</p>
        </div>

        <form id="book-issuance-form" action="controller" method="GET" accept-charset="UTF-8" style="display: none;">
            <input type="hidden" name="command" value="viewissuanceinfo">
            <input type="hidden" name="id" id="issuanceId">
            <input type="hidden" name="userLogin" id="issuanceUserLogin">
            <input type="hidden" name="author" id="issuanceAuthor">
            <input type="hidden" name="title" id="issuanceTitle">
            <input type="hidden" name="issuanceDate" id="issuanceDate">
            <input type="hidden" name="actualReturningDate" id="issuanceActualReturningDate">
        </form>

        <div class="booksContainer">
            <table style="width: 700px; font-size: 20px; ">
                <thead>
                <tr style="font-size: 30px;">
                    <th>Номер заявки</th>
                    <th style="width: 80px;">Логин читателя</th>
                    <th style="width: 700px;">Книга</th>
                    <th style="width: 200px;">Автор</th>
                    <th style="width: 200px;">Дата выдачи</th>
                    <th style="width: 200px;">Дата возврата</th>
                </tr>
                </thead>
                <tbody class="tableBody">
                    <c:forEach var="issuance" items="${issuances}">
                        <tr class='issuance-row' onclick="submitIssuanceForm(this);" data-proposal="${issuance.bookProposal}" data-login="${issuance.userLogin}" data-author="${issuance.author}" data-title="${issuance.bookTitle}" data-issuanceDate="${issuance.issuanceDate}" data-actualReturningDate="${issuance.actualReturningDate}">
                            <td>${issuance.bookProposal}</td>
                            <td>${issuance.userLogin}</td>
                            <td>${issuance.bookTitle}</td>
                            <td>${issuance.author}</td>
                            <td>${issuance.issuanceDate}</td>
                            <td>${issuance.actualReturningDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
