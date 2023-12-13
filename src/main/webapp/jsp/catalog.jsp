<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Каталог книг</title>
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

        <c:set var="user" value="${sessionScope.user}" />
        <c:choose>
            <c:when test="${user.roleName == 'ADMIN'}">
                <div class = "catalog-header" >
                    <p style="font-size: 40px; margin-top: 5px">Каталог книг</p>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="redirecttoaddbookpagecommand">
                        <button type="submit" id="button-hover" class = "user-button-submit">Добавить книгу</button>
                    </form>
                </div>

                <form id="book-request-form" action="controller" method="POST" accept-charset="UTF-8" style="display: none;">
                    <input type="hidden" name="command" value="viewbookinformation">
                    <input type="hidden" name="id" id="bookId">
                    <input type="hidden" name="title" id="bookTitle">
                    <input type="hidden" name="author" id="bookAuthor">
                    <input type="hidden" name="rating" id="bookRating">
                    <input type="submit" id="submitBtn" style="display: none;" formenctype="application/x-www-form-urlencoded;charset=UTF-8">
                </form>
            </c:when>
            <c:otherwise>
                <form id="book-request-form" action="controller" method="POST" accept-charset="UTF-8" style="display: none;">
                    <input type="hidden" name="command" value="viewbookinformation">
                    <input type="hidden" name="id" id="bookId">
                    <input type="hidden" name="title" id="bookTitle">
                    <input type="hidden" name="author" id="bookAuthor">
                    <input type="hidden" name="rating" id="bookRating">
                </form>
            </c:otherwise>
        </c:choose>

        <div class="booksContainer">
            <table style="width: 700px; font-size: 20px; ">
                <thead>
                <tr style="font-size: 30px;">
                    <th>Название книги</th>
                    <th style="width: 200px;">Автор книги</th>
                    <th style="width: 200px;">Рейтинг</th>
                </tr>
                </thead>
        <c:choose>
            <c:when test="${user.roleName == 'USER'}">
                <p style="font-size: 40px; margin-top: 0px">Каталог книг</p>
                <tbody class="tableBody">
                        <c:forEach var="book" items="${books}">
                            <tr class='book-row' onclick="submitForm(this);" data-id="${book.id}" data-title="${book.title}" data-author="${book.author}" data-rating="${book.rating}">
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.rating}</td>
                            </tr>
                        </c:forEach></c:when>
            <c:when test="${user.roleName ==  'ADMIN'}">
                <tbody class="tableBody">
                    <c:forEach var="book" items="${books}">
                        <tr class='book-row' onclick="submitForm(this)" data-id="${book.id}" data-title="${book.title}" data-author="${book.author}" data-rating="${book.rating}">
                            <td hidden>${book.id}</td>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.rating}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
