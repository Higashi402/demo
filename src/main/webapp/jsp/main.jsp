<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <%@include file='/css/style.css' %>
</head>
<body>
<h3>Welcome</h3>
<hr/>
${user}, hello!
<hr/>
<a href="login?command=logout">Logout</a>
</body>
</html>
