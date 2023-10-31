<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>

<div class="black-line-container">
    <hr class="black-line">
    <div class="centered-text">E-Book</div>
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
            ${errorLoginPassMessage}
        </div>
        ${wrongAction}
        ${nullPage}
        <div class = "btn btn-loginForm-button-submit btn-sep icon-info">
            <input type="submit" value="Авторизоваться" class="button" id="button-log">
        </div>

    </form>
</div>
<hr/>
</body>
</html>
