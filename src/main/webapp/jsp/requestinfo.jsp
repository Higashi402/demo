<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="status_INPROCESSING" value="INPROCESSING" />
<c:set var="status_READYFORPICKUP" value="READYFORPICKUP" />
<c:set var="status_ISSUED" value="ISSUED" />

<!DOCTYPE html>
<html>
<head>
    <title>Управление заявкой</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>
<%@include file="header.jsp"%>

<div class=requestEditForm>

    <div class = "request-edit-text" style="font-size: 30px">
        <h2>Информация о заявке</h2>
        <p>Имя пользователя: ${username}</p>
        <p>Id заявки: ${requestId}</p>
        <p>Название книги: ${requestTitle}</p>
        <p>Автор книги: ${requestAuthor}</p>
        <p>Статус заявки: ${requestStatus}</p>
    </div>

    <div class = "edit-request-buttons">
        <form action="controller" method="POST">
                <input type="hidden" name="command" value="updaterequeststatus">
                <input type="hidden" name="id" value="${requestId}">
                <input type="hidden" name="username" value="${username}">
                <label style="font-size: 30px" for="status">Изменить статус заявки:</label>
            <select name="status" id="status" style="font-size: 20px">
                <option value="${status_INPROCESSING}" ${requestStatus == 'INPROCESSING' ? 'selected' : ''}>В рассмотрении</option>
                <option value="${status_READYFORPICKUP}" ${requestStatus == 'READYFORPICKUP' ? 'selected' : ''}>Готова к выдаче</option>
                <option value="${status_ISSUED}" ${requestStatus == 'ISSUED' ? 'selected' : ''}>Выдана</option>
            </select>
            <input type="submit" id="button-hover" class = "user-button-submit" value="Изменить статус">
        </form>

        <form action="controller" method="POST">
            <input type="hidden" name="command" value="bookrequestdelete">
            <input type="hidden" name="id" value="${requestId}">
            <input type="hidden" name="username" value="${username}">
            <input type="submit" style="margin-top: 60px" id="button-hover" class = "user-button-submit" value="Удалить заявку">
        </form>
    </div>
</div>

</body>
</html>
