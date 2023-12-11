<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body> 

<div class="black-line-container">
    <hr class="login-black-line">
    <div class="login-centered-text">E-Book</div>
</div>

<div class = loginForm>
    <div class="loginForm-title">Авторизация</div>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="login"/>
        <div class = "loginForm-label-login">
            Логин:
        </div>
        <input type="text" name="login" value="" class="field-login"/>
        <div class = "loginForm-label-password">
            Пароль:
        </div>
        <input type="password" name="password" value="" class = "field-password"/>
        <br>
        <div class="error-wrongLogin">
            ${errormsg}
        </div>
        ${wrongAction}
        ${nullPage}
        <input type="submit" value="Авторизоваться" class="login-button-submit" id="button-hover">
    </form>
</div>
<hr/>
</body>
</html>
