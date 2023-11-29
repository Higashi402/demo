<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Соответствие строковых значений статуса и enum --%>
<c:set var="status_INPROCESSING" value="INPROCESSING" />
<c:set var="status_READYFORPICKUP" value="READYFORPICKUP" />
<c:set var="status_ISSUED" value="ISSUED" />

<!DOCTYPE html>
<html>
<head>
    <title>Управление заявкой</title>
</head>
<body>

<h2>Информация о заявке</h2>
<p>Имя пользователя: ${username}</p>
<p>Id заявки: ${requestId}</p>
<p>Название книги: ${requestTitle}</p>
<p>Автор книги: ${requestAuthor}</p>
<p>Статус заявки: ${requestStatus}</p>

<form action="controller" method="POST">
    <input type="hidden" name="command" value="updaterequeststatus">
    <input type="hidden" name="id" value="${requestId}">
    <input type="hidden" name="username" value="${username}">
    <label for="status">Изменить статус заявки:</label>
    <select name="status" id="status">
        <option value="${status_INPROCESSING}" ${requestStatus == 'INPROCESSING' ? 'selected' : ''}>INPROCESSING</option>
        <option value="${status_READYFORPICKUP}" ${requestStatus == 'READYFORPICKUP' ? 'selected' : ''}>READYFORPICKUP</option>
        <option value="${status_ISSUED}" ${requestStatus == 'ISSUED' ? 'selected' : ''}>ISSUED</option>
    </select>
    <input type="submit" value="Изменить статус">
</form>

<form action="controller" method="POST">
    <input type="hidden" name="command" value="bookrequestdelete">
    <input type="hidden" name="id" value="${requestId}">
    <input type="hidden" name="username" value="${username}">
    <input type="submit" value="Удалить заявку">
</form>

</body>
</html>
