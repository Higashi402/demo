<%@ page pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="black-line-container">
    <hr class="user-black-line">
    <div class="user-centered-text">E-Book</div>
</div>

<div class = "user-buttons">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="viewbooks">
        <button type="submit" id="button-hover" onclick="openForm('viewBooksForm')" class="user-buttons-catalog">Просмотр каталога книг</button>
    </form>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="bookrequestviewcommand">
        <button type="submit" id="button-hover" onclick="openForm('requestsForm')" class="user-buttons-request">Просмотр заявок</button>
    </form>
    <button id="button-hover" onclick="openForm('confirmExitForm')" class = "user-buttons-exit"></button>
</div>
</body>
</html>
