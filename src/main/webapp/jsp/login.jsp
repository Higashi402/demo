<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>

<div class = loginForm>
    <div class="loginForm-title">Авторизация</div>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="login"/>
        <div class = "loginForm-label-login">
            Логин:
        </div>
        <input type="text" name="login" value="" class="field-login"/>
        <div class = "loginForm-label-password">
            <br/>Пароль:
        </div>
        <input type="password" name="password" value="" class = "field-password"/>
        <br/>
        ${errorLoginPassMessage}
        <br/>
        ${wrongAction}
        <br/>
        ${nullPage}
        <br/>
        <div class = "btn btn-loginForm-button-submit btn-sep icon-info">
            <div type="submit" value="Log in" class="button" id="button-2">
                <div id="slide"></div>
                <a href="#">Авторизоваться</a>
            </div>
        </div>
    </form>
</div>
<hr/>
</body>
</html>
